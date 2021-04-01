package prac_12;

import java.util.StringTokenizer;

public class Address {
    String Country, Region, City, Street, House, Housing, Flat;
    Address(String address){
        StringTokenizer st = new StringTokenizer(address, ",.;");
        Country = st.nextToken().trim();
        Region = st.nextToken().trim();
        City = st.nextToken().trim();
        Street = st.nextToken().trim();
        House = st.nextToken().trim();
        Housing = st.nextToken().trim();
        Flat = st.nextToken().trim();
    }

    @Override
    public String toString() {
        return "Address: " + Country + ", " + Region + ", " + City + ", " + Street
                + ", " + House + ", " + Housing + ", " + Flat;
    }
}
