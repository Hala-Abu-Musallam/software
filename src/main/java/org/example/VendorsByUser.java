package org.example;

import java.io.*;
import java.util.ArrayList;

public class VendorsByUser{

    public static String email;
    public static String type;
    public static int price;

    public static String username;

    public static String date;
    public static String time;
    public static boolean addSuccess;

    public static int vendor_type;

    ArrayList<VendorsByUser> vendors = new ArrayList<>();
    public void getVendorsfromFile() {
        try {

            vendors.clear();
            File file = new File("src/vendors.txt");
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String EmailPriceType;
                while ((EmailPriceType = bufferedReader.readLine()) != null) {
                    String[] data = EmailPriceType.split(",");
                    email=data[0];
                    price=Integer.parseInt(data[1]);
                    type=data[2];
                    vendors.add(this);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void writeVendors(String username, String date, String time,String email,String type) {
        try {
            File file = new File("src/waitList.txt");
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
                String vendor = username + "," + date + "," + time + ","+email + "," + type+"\n";
                System.out.println(vendor);
                bufferedWriter.write(vendor);
                System.out.println(vendor);
                addSuccess = true;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



    }

    public void addvendor (String usernamee,String typee ,String datee,String timee,String email){
        date=datee;
        type=typee;
        time=timee;
        username=usernamee;
        System.out.println(type);
        System.out.println(date);
        System.out.println(time);

        getVendorsfromFile();
        if ( typee.equals ( "decoration" ) ){
            vendor_type = 1;

            writeVendors (username , date , time ,email,typee );

        }
        else if (typee.equals("DJ")){
            vendor_type = 2 ;
            writeVendors (username , date , time ,email,typee );
        }
        else if (typee.equals("photographer")){
            vendor_type = 3 ;
            writeVendors (username , date , time ,email,typee);
        }
        else{
            vendor_type=-1;
        }
    }
}