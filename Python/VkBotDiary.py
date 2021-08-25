from os import chdir

from vk_api import VkApi
from vk_api.longpoll import VkLongPoll, VkEventType

from InitConfig import Config
from BotParser import Parser
from VkBotChat import VkBotChat

def main():
    """Функция запуска бота и прослушивание им сообщений от пользователя"""
    config = Config()
    parser = Parser()
    schedule = parser.get_schedules()
    vk_session = VkApi(token=config.get_token())
    vk_session_user = None
    if config.get_user_info():
        chdir(config.get_dir_name())
        login, password = config.get_user_info()
        vk_session_user = VkApi(login, password)
        vk_session_user.auth()
        chdir("..")
    print("Бот залогинился!")
    longpoll = VkLongPoll(vk_session)
    print("Бот начал слушать сообщения!")

    for event in longpoll.listen():
        if event.type == VkEventType.MESSAGE_NEW and event.text and event.to_me:
            bot = VkBotChat(vk_session, event.user_id, vk_session_user)
            user_message = event.text.lower()
            bot.get_response(user_message, schedule, config)


if __name__ == '__main__':
    main()
