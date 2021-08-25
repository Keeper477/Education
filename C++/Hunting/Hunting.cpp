#include <conio.h>
#include <iostream>
#include <windows.h>
#include <time.h>
using namespace std;
const int col = 120;
const int row = 80;


void mnogokorovok(int karta[32][64], int years[32][64]) {
	// Коровки размножаются 
	for (int i = 0; i < 32; i++) {
		for (int j = 0; j < 64; j = j + 2) {
			if (karta[i][j] == 3 and years[i][j] > 7 and years[i][j] < 15) {
				if (karta[i][j + 2] == 3 && years[i][j + 2] > 8 and years[i][j + 2] < 15
					|| karta[i][j - 2] == 3 && years[i][j - 2] > 8 and years[i][j - 2] < 15
					|| karta[i + 1][j] == 3 && years[i + 1][j] > 8 and years[i + 1][j] < 15
					|| karta[i - 1][j] == 3 && years[i - 1][j] > 8 and years[i - 1][j] < 15) {
					int l = rand() % 4;
					if (l == 0) {
						if (i > 0)
							if (karta[i + 1][j] != 2 && karta[i + 1][j] != 4 && karta[i + 1][j] != 3) {
								karta[i + 1][j] = 3;
								karta[i + 1][j + 1] = 3;
								years[i + 1][j] = 1;
								years[i + 1][j + 1] = 1;
							}
					}
					else if (l == 1) {
						if (i < 31)
							if (karta[i - 1][j] != 2 && karta[i - 1][j] != 4 && karta[i - 1][j] != 3) {
								karta[i - 1][j] = 3;
								karta[i - 1][j + 1] = 3;
								years[i - 1][j] = 1;
								years[i - 1][j + 1] = 1;
							}
					}
					else if (l == 2) {
						if (j < 62)
							if (karta[i][j + 2] != 2 && karta[i][j + 2] != 4 && karta[i][j + 2] != 3) {
								karta[i][j + 2] = 3;
								karta[i][j + 2 + 1] = 3;
								years[i][j + 2] = 1;
								years[i][j + 2 + 1] = 1;
							}
					}
					else if (l == 3) {
						if (j > 0)
							if (karta[i][j - 2] != 2 && karta[i][j - 2] != 4 && karta[i][j - 2] != 3) {
								karta[i][j - 2] = 3;
								karta[i][j - 2 + 1] = 3;
								years[i][j - 2] = 1;
								years[i][j - 2 + 1] = 1;
							}
					}
				}
			}
		}
	}
}

void movevolk(int i, int j, int karta[32][64], int years[32][64], int golod[32][64], int kakdela[32][64], int h, int g, int k) {
	//Волк переходит в соседнюю клетку
	if (karta[i + h][j + g] != 2 && karta[i + h][j + g] != 4 and k > years[i][j + 1]) {
		if (karta[i + h][j + g] == 3) {
			golod[i][j] = 0;
			if (kakdela[i][j] == 0) {
				kakdela[i][j] = -1;
			}
			else if (kakdela[i][j] == 1) {
				for (int n = 0; n < 32; n++) {
					for (int m = 0; m < 64; m = m + 2) {
						if (kakdela[n][m + 1] == kakdela[i][j + 1] and (n != i or m != j)) {
							kakdela[n][m] = -1;
							kakdela[n][m + 1] = -1;
							golod[n][m] = 0;
						}
					}
				}
				kakdela[i][j] = -1;
				kakdela[i][j + 1] = -1;
				golod[i][j] = 0;
			}
		}
		if (karta[i + h][j + g] == 1 or karta[i + h][j + g] == 5) {
			golod[i + h][j + g + 1] = years[i + h][j + g];
			karta[i + h][j + g] = 4;
			karta[i + h][j + g + 1] = 4;
			years[i + h][j + g] = years[i][j];
			kakdela[i + h][j + g] = kakdela[i][j];
			kakdela[i + h][j + g + 1] = kakdela[i][j + 1];
			years[i + h][j + g + 1] = k;
			golod[i + h][j + g] = golod[i][j];
			if (golod[i][j + 1] != 0) {
				karta[i][j] = 5;
				karta[i][j + 1] = 5;
				years[i][j] = golod[i][j + 1] - 1;
				years[i][j + 1] = 0;
				golod[i][j + 1] = 0;
				golod[i][j] = 0;
			}
			else
			{
				karta[i][j] = 0;
				karta[i][j + 1] = 0;
				years[i][j] = 0;
				years[i][j + 1] = 0;
				golod[i][j] = 0;
			}
		}
		else {
			karta[i + h][j + g] = 4;
			karta[i + h][j + g + 1] = 4;
			years[i + h][j + g] = years[i][j];
			kakdela[i + h][j + g] = kakdela[i][j];
			kakdela[i + h][j + g + 1] = kakdela[i][j + 1];
			years[i + h][j + g + 1] = k;
			golod[i + h][j + g] = golod[i][j];
			if (golod[i][j + 1] != 0) {
				karta[i][j] = 5;
				karta[i][j + 1] = 5;
				years[i][j] = golod[i][j + 1] - 1;
				golod[i][j + 1] = 0;
				years[i][j + 1] = 0;
				golod[i][j] = 0;
			}
			else
			{
				karta[i][j] = 0;
				karta[i][j + 1] = 0;
				years[i][j] = 0;
				years[i][j + 1] = 0;
				golod[i][j] = 0;
			}
		}
	}
}

void ohota(int a[1], int i, int j, int karta[32][64], int years[32][64], int golod[32][64], int kakdela[32][64], int k) {
	// kakdela[i][j] - что делает волк, kakdela[i][j + 1] - номер команды 
	int q1, p1, q2, p2, b = 82, c = 82, b1 = -1, c1 = -1, y = 0, f = 0, d = 0, g = 0, l = 82, l1 = 82;
	if (kakdela[i][j] == 0) {
		//Поиск других и продвижение к центру,
		q1 = i - 4;
		q2 = i + 4;
		p1 = j - 8;
		p2 = j + 8;
		if (q1 < 0)
			q1 = 0;
		if (p1 < 0)
			p1 = 0;
		if (q2 > 31)
			q2 = 31;
		if (p2 > 63)
			p2 = 62;
		f = 0;
		for (int n = q1; n < q2 + 1; n++) {
			for (int m = p1; m < p2 + 1; m = m + 2) {
				if (karta[n][m] == 4 and (kakdela[n][m] == 0 or kakdela[n][m] == 1) and (m != j or n != i)) {
					f = 1;
					if (abs(i - n) <= abs(i - b) and abs(j - m) <= abs(j - c)) {
						b = n;
						c = m;
					}
				}
			}
		}
		//ищем других волков
		if (abs(b - i) <= 1 and abs(c - j) <= 2 and (kakdela[b][c] == 0 or kakdela[b][c] == 1)) {
			kakdela[i][j] = 1;
			kakdela[b][c] = 1;
			if (kakdela[b][c + 1] == -1) {
				a[0] += 1;
				kakdela[b][c + 1] = a[0];
				kakdela[i][j + 1] = a[0];
			}
			else {
				kakdela[i][j + 1] = kakdela[b][c + 1];
			}

			return;
		}
		if (f == 1) {
			// ход в сторону найденого
			if (b - i == 0) {
				b = 0;
			}
			else if (i - b > 0) {
				b = -1;
			}
			else {
				b = 1;
			}
			if (c - j == 0) {
				c = 0;
			}
			else if (j - c > 0) {
				c = -2;
			}
			else {
				c = 2;
			}
			if (k > years[i][j + 1]) {
				if (b != 0 && y == 0) {
					movevolk(i, j, karta, years, golod, kakdela, b, 0, k);
					if (0 == years[i][j + 1])
						y = 1;
				}
				if (c != 0 && y == 0) {
					movevolk(i, j, karta, years, golod, kakdela, 0, c, k);
					if (0 == years[i][j + 1])
						y = 1;
				}
				if (y == 0) {
					movevolk(i, j, karta, years, golod, kakdela, -b, 0, k);
					if (0 == years[i][j + 1])
						y = 1;
				}
				if (y == 0) {
					movevolk(i, j, karta, years, golod, kakdela, 0, -c, k);
					if (0 == years[i][j + 1])
						y = 1;
				}
			}
		}
		else {
			//ход в сторону центра
			if (i - 16 == 0) {
				b = 0;
			}
			else if (i - 16 > 0) {
				b = -1;
			}
			else {
				b = 1;
			}
			if (j - 32 == 0) {
				c = 0;
			}
			else if (j - 32 > 0) {
				c = -2;
			}
			else {
				c = 2;
			}
			if (i != 15 and i != 14 and i != 13 and y == 0) {
				movevolk(i, j, karta, years, golod, kakdela, b, 0, k);
				if (0 == years[i][j + 1])
					y = 1;
			}
			if (j != 31 and i != 30 and y == 0) {
				movevolk(i, j, karta, years, golod, kakdela, 0, c, k);
				if (0 == years[i][j + 1])
					y = 1;
			}
			if (i != 15 and i != 14 and i != 13 and y == 0) {
				movevolk(i, j, karta, years, golod, kakdela, -b, 0, k);
				if (0 == years[i][j + 1])
					y = 1;
			}
			if (j != 31 and i != 30 and y == 0) {
				movevolk(i, j, karta, years, golod, kakdela, 0, -c, k);
				if (0 == years[i][j + 1])
					y = 1;
			}
		}
	}
	//охота
	else if (kakdela[i][j] == 1) {
		// определить потеряшки
		q1 = i - 4;
		q2 = i + 4;
		p1 = j - 8;
		p2 = j + 8;
		if (q1 < 0)
			q1 = 0;
		if (p1 < 0)
			p1 = 0;
		if (q2 > 31)
			q2 = 31;
		if (p2 > 63)
			p2 = 62;
		f = 0;
		for (int n = q1; n < q2 + 1; n++) {
			for (int m = p1; m < p2 + 1; m = m + 2) {
				if (karta[n][m] == 4 and kakdela[n][m + 1] == kakdela[i][j + 1]) {
					f = 1;
				}
			}
		}
		if (f != 1) {
			kakdela[i][j] = 0;
			kakdela[i][j + 1] = -1;
			return;
		}
		if (k > years[i][j + 1]) {
			// создаем радиус видимости
			for (int n = 0; n < 32; n++) {
				for (int m = 0; m < 64; m = m + 2) {
					if (kakdela[n][m + 1] == kakdela[i][j + 1]) {
						if (b > n) {
							b = n;
						}
						if (b1 < n) {
							b1 = n;
						}
						if (c > m) {
							c = m;
						}
						if (c1 < m) {
							c1 = m;
						}
					}
				}
			}
			b = b - 3;
			b1 = b1 + 3;
			c = c - 6;
			c1 = c1 + 6;
			if (b < 0)
				b = 0;
			if (b1 > 31)
				b1 = 31;
			if (c < 0)
				c = 0;
			if (c1 > 63)
				c1 = 62;
			f = 0;
			for (int n = b; n < b1 + 1; n++) {
				for (int m = c; m < c1 + 1; m = m + 2) {
					// их цель
					if (karta[n][m] == 3 and kakdela[n][m] == kakdela[i][j + 1]) {
						l = n;
						l1 = m;
						f = 2;
						break;
					}
					//поиск цели
					else if (karta[n][m] == 3 and kakdela[n][m] == -1) {
						if (abs(n - (b1 - b) / 2) <= abs(l - (b1 - b) / 2) and abs(m - (c1 - c) / 2) <= abs(l1 - (c1 - c) / 2)) {
							l = n;
							l1 = m;
						}
						f = 1;
					}
				}
				if (f == 2)
					break;
			}
			if (f == 1 or f == 2) {
				// идем в сторону коровки
				if (l - i == 0) {
					d = 0;
				}
				else if (i - l > 0) {
					d = -1;
				}
				else {
					d = 1;
				}
				if (l1 - j == 0) {
					g = 0;
				}
				else if (j - l1 > 0) {
					g = -2;
				}
				else {
					g = 2;
				}
				if (k > years[i][j + 1]) {
					if (d != 0) {
						movevolk(i, j, karta, years, golod, kakdela, d, 0, k);
					}
					else if (g != 0) {
						movevolk(i, j, karta, years, golod, kakdela, 0, g, k);
					}
				}
			}
			else if (f == 0) {
				//просто идем
				int l = rand() % 4;
				if (l == 0) {
					if (i > 0) {
						movevolk(i, j, karta, years, golod, kakdela, -1, 0, k);
						d = -1;
						g = 0;
					}
				}
				else if (l == 1) {
					if (i < 31) {
						movevolk(i, j, karta, years, golod, kakdela, 1, 0, k);
						d = 1;
						g = 0;
					}
				}
				else if (l == 2) {
					if (j < 62) {
						movevolk(i, j, karta, years, golod, kakdela, 0, 2, k);
						d = 0;
						g = 2;
					}
				}
				else if (l == 3) {
					if (j > 0) {
						movevolk(i, j, karta, years, golod, kakdela, 0, -2, k);
						d = 0;
						g = -2;
					}
				}
				for (int p = b; p < b1 + 1; p++) {
					for (int q = c; q < c1 + 1; q = q + 2) {
						if (karta[p][q] == 4 and kakdela[p][q + 1] == kakdela[i][j + 1]) {
							if (d == -1) {
								if (p > 0) {
									movevolk(p, q, karta, years, golod, kakdela, -1, 0, k);
								}
							}
							else if (d == 1) {
								if (p < 31) {
									movevolk(p, q, karta, years, golod, kakdela, 1, 0, k);
								}
							}
							else if (g == 2) {
								if (q < 62) {
									movevolk(p, q, karta, years, golod, kakdela, 0, 2, k);
								}
							}
							else if (g == -2) {
								if (q > 0) {
									movevolk(p, q, karta, years, golod, kakdela, 0, -2, k);
								}
							}
						}
					}
				}
				kakdela[i][j + 1] = -1;
				kakdela[i][j] = -1;
			}
		}
	}
}

void movekorovka(int i, int j, int karta[32][64], int years[32][64], int golod[32][64], int kakdela[32][64], int h, int g, int k) {
	if (karta[i + h][j + g] != 2 && karta[i + h][j + g] != 4 && karta[i + h][j + g] != 3) {
		if (karta[i + h][j + g] == 1 || karta[i + h][j + g] == 5) {
			golod[i][j] = 0;
		}
		karta[i + h][j + g] = 3;
		karta[i + h][j + g + 1] = 3;
		years[i + h][j + g] = years[i][j];
		kakdela[i + h][j + g] = kakdela[i][j];
		years[i + h][j + g + 1] = k;
		golod[i + h][j + g] = golod[i][j];
		karta[i][j] = 0;
		karta[i][j + 1] = 0;
		years[i][j] = 1;
		years[i][j + 1] = 1;
		golod[i][j] = 0;
	}
}

void volchok(int a[1], int x, int karta[32][64], int years[32][64], int golod[32][64], int kakdela[32][64], int k) {
	switch (x)
	{
		// volchok двигается и ест
	case 1:
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j = j + 2) {
				if (karta[i][j] == 4 && k > years[i][j + 1]) {
					if (golod[i][j] < 6 or (golod[i][j] > 9 and kakdela[i][j] == 0)) {
						if (years[i][j] < 6 or years[i][j] > 23) {
							int l = rand() % 4;
							if (l == 0) {
								if (i > 0) {
									movevolk(i, j, karta, years, golod, kakdela, -1, 0, k);
									years[i - 1][j + 1] = k + 1;
								}
							}
							else if (l == 1) {
								if (i < 31) {
									movevolk(i, j, karta, years, golod, kakdela, 1, 0, k);
									years[i + 1][j + 1] = k + 1;
								}
							}
							else if (l == 2) {
								if (j < 62) {
									movevolk(i, j, karta, years, golod, kakdela, 0, 2, k);
									years[i][j + 2 + 1] = k + 1;
								}
							}
							else if (l == 3) {
								if (j > 0) {
									movevolk(i, j, karta, years, golod, kakdela, 0, -2, k);
									years[i][j - 2 + 1] = k + 1;
								}
							}
						}
						else {
							int l = rand() % 4;
							if (l == 0) {
								if (i > 0)
									movevolk(i, j, karta, years, golod, kakdela, -1, 0, k);
							}
							else if (l == 1) {
								if (i < 31)
									movevolk(i, j, karta, years, golod, kakdela, 1, 0, k);
							}
							else if (l == 2) {
								if (j < 62)
									movevolk(i, j, karta, years, golod, kakdela, 0, 2, k);
							}
							else if (l == 3) {
								if (j > 0)
									movevolk(i, j, karta, years, golod, kakdela, 0, -2, k);
							}
						}
					}
					else
					{
						if (kakdela[i][j] == -1)
							kakdela[i][j] = 0;
						ohota(a, i, j, karta, years, golod, kakdela, k);
					}
				}
			}
		}
		break;
		// volchok стареет и умирает
	case 2:
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j = j + 2) {
				if (karta[i][j] == 4) {
					if (years[i][j] > 28) {
						karta[i][j] = 0;
						karta[i][j + 1] = 0;
						years[i][j] = 1;
						years[i][j + 1] = 1;
						golod[i][j] = 0;
					}
					if (golod[i][j] > 12) {
						karta[i][j] = 0;
						karta[i][j + 1] = 0;
						years[i][j] = 1;
						years[i][j + 1] = 1;
						golod[i][j] = 0;
					}
				}
			}
		}
		break;
	}
}

void korovka(int x, int karta[32][64], int years[32][64], int golod[32][64], int kakdela[32][64], int k) {
	switch (x)
	{
		// korovka двигается и ест
	case 1:
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j = j + 2) {
				if (karta[i][j] == 3 && k > years[i][j + 1]) {
					if (years[i][j] > 7 and years[i][j] < 15) {
						int l = rand() % 4;
						if (l == 0) {
							if (i > 0)
								movekorovka(i, j, karta, years, golod, kakdela, -1, 0, k);
						}
						else if (l == 1) {
							if (i < 31)
								movekorovka(i, j, karta, years, golod, kakdela, 1, 0, k);
						}
						else if (l == 2) {
							if (j < 62)
								movekorovka(i, j, karta, years, golod, kakdela, 0, 2, k);
						}
						else if (l == 3) {
							if (j > 0)
								movekorovka(i, j, karta, years, golod, kakdela, 0, -2, k);
						}
					}
					else
					{
						int l = rand() % 4;
						if (l == 0) {
							if (i > 0) {
								movekorovka(i, j, karta, years, golod, kakdela, -1, 0, k);
								years[i - 1][j + 1] = k + 1;
							}
						}
						else if (l == 1) {
							if (i < 31) {
								movekorovka(i, j, karta, years, golod, kakdela, 1, 0, k);
								years[i + 1][j + 1] = k + 1;
							}
						}
						else if (l == 2) {
							if (j < 62) {
								movekorovka(i, j, karta, years, golod, kakdela, 0, 2, k);
								years[i][j + 2 + 1] = k + 1;
							}
						}
						else if (l == 3) {
							if (j > 0) {
								movekorovka(i, j, karta, years, golod, kakdela, 0, -2, k);
								years[i][j - 2 + 1] = k + 1;
							}
						}

					}
				}
			}
		}
		break;
		// korovka стареет и умирает
	case 2:
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j = j + 2) {
				if (karta[i][j] == 3) {
					if (years[i][j] > 20) {
						karta[i][j] = 0;
						karta[i][j + 1] = 0;
						years[i][j] = 1;
						years[i][j + 1] = 1;
					}
					if (golod[i][j] > 10) {
						karta[i][j] = 0;
						karta[i][j + 1] = 0;
						years[i][j] = 1;
						years[i][j + 1] = 1;
						golod[i][j] = 0;
					}
				}
			}
		}
		break;
	}
}

void travka(int x, int karta[32][64], int years[32][64], int k) {
	switch (x)
	{
		// travka размножается
	case 1:
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j = j + 2) {
				if (karta[i][j] == 1 or karta[i][j] == 5) {
					if (j < 62) {
						if (karta[i][j + 2] == 0) {
							karta[i][j + 2] = 1;
							years[i][j + 2] = 0;
							karta[i][j + 3] = 1;
							j = j + 2;
						}
					}
					if (j > 0) {
						if (karta[i][j - 1] == 0) {
							karta[i][j - 1] = 1;
							karta[i][j - 2] = 1;
							years[i][j - 2] = 0;
						}
					}
					if (i < 31) {
						if (karta[i + 1][j] == 0) {
							karta[i + 1][j] = 1;
							karta[i + 1][j + 1] = 1;
							years[i + 1][j] = 0;
							i = i + 1;
						}
					}
					if (i > 0) {
						if (karta[i - 1][j] == 0) {
							karta[i - 1][j] = 1;
							karta[i - 1][j + 1] = 1;
							years[i - 1][j] = 0;
						}
					}
				}
			}
		}
		break;
		// travka стареет и умирает
	case 2:
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j = j + 2) {
				if (karta[i][j] == 1 or karta[i][j] == 5) {
					if (years[i][j] == 2) {
						karta[i][j] = 5;
						karta[i][j + 1] = 5;
					}
					if (years[i][j] >= 3) {
						karta[i][j] = 0;
						karta[i][j + 1] = 0;
						years[i][j] = 1;
					}
				}
			}
		}
		break;
	}
}

void respawn(int a, int b, int karta[32][64]) {
	//Появление
	int k = 1, g = 1;
	for (int i = 0; i < b; i++) {
		while (TRUE)
		{
			k = (rand() % 32);
			g = (rand() % 64) / 2 * 2;
			if (karta[k][g] == 0) {
				karta[k][g] = a;
				karta[k][g + 1] = a;
				break;
			}
		}
	}
}

void zagruzka(HANDLE wHnd, int posx, int posy, int pictLetterA[32][64])
{
	//Рисовка
	const int rowA = 32;
	const int colA = 64;

	CONSOLE_SCREEN_BUFFER_INFO csbiInfo;
	GetConsoleScreenBufferInfo(wHnd, &csbiInfo);
	CHAR_INFO picBufferA[colA * rowA];

	for (int i = 0; i < colA * rowA; ++i) {
		picBufferA[i].Char.UnicodeChar = ' ';
		picBufferA[i].Attributes = csbiInfo.wAttributes;
	}
	for (int i = 0; i < rowA; i++)
		for (int j = 0; j < colA; j++) {
			if (pictLetterA[i][j] == 0)
				picBufferA[i * colA + j].Attributes = 0;
			if (pictLetterA[i][j] == 1)
				picBufferA[i * colA + j].Attributes = BACKGROUND_GREEN;
			if (pictLetterA[i][j] == 2)
				picBufferA[i * colA + j].Attributes = BACKGROUND_RED | BACKGROUND_GREEN | BACKGROUND_BLUE;
			if (pictLetterA[i][j] == 3)
				picBufferA[i * colA + j].Attributes = BACKGROUND_BLUE;
			if (pictLetterA[i][j] == 4)
				picBufferA[i * colA + j].Attributes = BACKGROUND_RED;
			if (pictLetterA[i][j] == 5)
				picBufferA[i * colA + j].Attributes = BACKGROUND_RED | BACKGROUND_GREEN;
			if (pictLetterA[i][j] == 6)
				picBufferA[i * colA + j].Attributes = BACKGROUND_RED | BACKGROUND_BLUE;
		}

	SMALL_RECT writeArea = { posx, posy, posx + colA, posy + rowA };
	WriteConsoleOutput(wHnd, picBufferA,
		{ colA,rowA }, { 0,0 }, &writeArea);
}

void smert(HANDLE wHnd, int a, int karta[32][64], int years[32][64], int golod[32][64]) {
	// Метеорит
	int k, p, q, v;
	k = 1 + rand() % 100;
	if (k <= a) {
		p = 1 + rand() % 30;
		q = 2 + rand() % 59 / 2 * 2;
		karta[p][q] = 6;
		karta[p][q + 1] = 6;

		karta[p][q + 2] = 6;
		karta[p][q + 2 + 1] = 6;

		karta[p][q - 2] = 6;
		karta[p][q - 2 + 1] = 6;

		karta[p + 1][q + 2] = 6;
		karta[p + 1][q + 2 + 1] = 6;

		karta[p + 1][q - 2] = 6;
		karta[p + 1][q - 2 + 1] = 6;

		karta[p - 1][q + 2] = 6;
		karta[p - 1][q + 2 + 1] = 6;

		karta[p - 1][q - 2] = 6;
		karta[p - 1][q - 2 + 1] = 6;

		karta[p + 1][q] = 6;
		karta[p + 1][q + 1] = 6;

		karta[p - 1][q] = 6;
		karta[p - 1][q + 1] = 6;

		zagruzka(wHnd, 40, 2, karta);
		Sleep(200);
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < 64; j++) {
				if (karta[i][j] == 6) {
					karta[i][j] = 0;
					years[i][j] = 0;
					golod[i][j] = 0;
				}
			}
		}
		zagruzka(wHnd, 40, 2, karta);
	}
}

int main() {
	HANDLE wHnd = GetStdHandle(STD_OUTPUT_HANDLE);
	SMALL_RECT windowSize = { 0,0,col - 1,row - 1 };
	SetConsoleWindowInfo(wHnd, TRUE, &windowSize);
	COORD bufferSize = { col,row };
	SetConsoleScreenBufferSize(wHnd, bufferSize);
	srand((unsigned)time(NULL));
	CHAR_INFO consBuffer[col * row];
	int karta[32][64], years[32][64], volchoki = 0, korovki = 0, golod[32][64], ohota[32][64], kakdela[32][64];
	setlocale(LC_CTYPE, "rus");

	for (int i = 0; i < 32; i++) {
		for (int j = 0; j < 64; j++) {
			karta[i][j] = 0;
			years[i][j] = 1;
			golod[i][j] = 0;
			kakdela[i][j] = -1;
		}
	}

	int b;
	for (int i = 1; i < 5; i++) {
		if (i == 1)
			cout << "Введите кол-во травы" << endl;
		if (i == 2)
			cout << "Введите кол-во деревьев" << endl;
		if (i == 3)
			cout << "Введите кол-во коров" << endl;
		if (i == 4)
			cout << "Введите кол-во волков" << endl;
		cin >> b;
		respawn(i, b, karta);
	}
	cout << "Какой шанс катастроф" << endl;
	int e;
	cin >> e;

	int k = 0, a[1] = { -1 };
	while (TRUE) {
		zagruzka(wHnd, 40, 2, karta);
		k++;
		if (k % 20 == 0) {
			travka(1, karta, years, k);
		}
		if (k % 30 == 0) {
			mnogokorovok(karta, years);
		}
		if (k == 62) {
			k = 0;
			for (int i = 0; i < 32; i++) {
				for (int j = 0; j < 64; j = j + 2) {
					if (karta[i][j] != 0) {
						years[i][j]++;
						golod[i][j]++;
						if (years[i][j] > 10) {
							golod[i][j]++;
						}
						if (karta[i][j + 1] != 1 and karta[i][j + 1] != 5)
							years[i][j + 1] = k;
					}
				}
			}
		}
		volchok(a, 1, karta, years, golod, kakdela, k);
		korovka(1, karta, years, golod, kakdela, k);
		smert(wHnd, e, karta, years, golod);
		travka(2, karta, years, k);
		volchok(a, 2, karta, years, golod, kakdela, k);
		korovka(2, karta, years, golod, kakdela, k);
		Sleep(100);
	}
}

