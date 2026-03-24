import java.util.*;
class StoreManagementSystem{
    Scanner sc = new Scanner(System.in);

    int product_Quantity;
    String product_ID, product_Name, product_Quality;
    double product_Price;

    void setData(){


        boolean flag = false;
        do{
            System.out.print("Enter Product ID         : ");
            product_ID = sc.next();

            flag = isInteger(product_ID);

        }while(flag == false);


        flag = false;
        do{
            System.out.print("Enter Product Name       : ");
            product_Name = sc.next();

            flag = isValidName(product_Name);

        }while(flag == false);


        flag = false;
        do{
            System.out.print("Enter Product Quantity   : ");
            product_Quantity = sc.nextInt();

            if(product_Quantity<0){
                System.out.println("Invalid Formate !!!");
                flag = false;
            }
            else
                flag = true;

        }while(flag == false);


        flag = false;
        do{
            System.out.print("Enter Product Price      : ");
            product_Price = sc.nextDouble();

            if(product_Price<0.0){
                System.out.println("Invalid Formate !!!");
                flag = false;
            }
            else
                flag = true;

        }while(flag == false);


        flag = false;
        do{
            System.out.print("Enter Product Quality [Formate: A/B/C/D/E]  : ");
            product_Quality = sc.next();

            flag = isValidQuality(product_Quality);

        }while(flag == false);
        System.out.println();
    }



    void display(){
        System.out.println("                 *****************************");
        System.out.println("                 Product ID          : " + product_ID);
        System.out.println("                 Product Name        : " + product_Name);
        System.out.println("                 Product Quantity    : " + product_Quantity);
        System.out.println("                 Product Price       : " + product_Price);
        System.out.println("                 Product Quality     : " + product_Quality);
        System.out.println("                 *****************************");
    }




    void updateData(String updt_ID){
        int choice=0;
        boolean flag = searchID(updt_ID);
        if(flag==true){
            System.out.println("Which Detail You Wants To Update?");
            System.out.println();
            System.out.println("Press 1 To Update Name.");
            System.out.println("Press 2 To Update Quantity.");
            System.out.println("Press 3 To Update Price.");
            System.out.println("Press 4 To Update Quality.");
            System.out.println();
            System.out.println("Enter Your Choice.");
            choice = sc.nextInt();

            switch(choice){
                case 1 :

                    flag = false;
                    do{
                        System.out.print("Enter Updated Product Name : ");
                        product_Name = sc.next();

                        flag = isValidName(product_Name);

                    }while(flag == false);
                    System.out.println("Product Name Updated Successfully :)");
                    break;

                case 2 :
                    flag = false;
                    do{
                        System.out.print("Enter Updated Product Quantity : ");
                        product_Quantity = sc.nextInt();

                        if(product_Quantity<0){
                            System.out.println("Invalid Formate !!!");
                            flag = false;
                        }
                        else
                            flag = true;

                    }while(flag == false);
                    System.out.println("Product Quantity Updated Successfully :)");
                    break;

                case 3 :
                    flag = false;
                    do{
                        System.out.print("Enter Upadted Product Price : ");
                        product_Price = sc.nextDouble();

                        if(product_Price<0.0){
                            System.out.println("Invalid Formate !!!");
                            flag = false;
                        }
                        else
                            flag = true;

                    }while(flag == false);
                    System.out.println("Product Price Updated Successfully :)");
                    break;

                case 4 :
                    flag = false;
                    do{
                        System.out.print("Enter Updated Product Quality [Formate: A/B/C/D/Z] : ");
                        product_Quality = sc.next();

                        flag = isValidQuality(product_Quality);

                    }while(flag == false);
                    System.out.println("Product Quality Updated Successfully :)");
                    break;

                default : System.out.println("Invalid Parameter !!!");
            }
        }
        else{
            System.out.println("Not Found");
        }
    }



    void searchNdisplayByID(String search_ID){
        boolean flag = searchID(search_ID);
        if(flag==true){
            System.out.println();
            display();
        }
        else
            System.out.println("Not Found !!!!");
    }


    void searchNdisplayByName(String search_Name){
        boolean flag = searchName(search_Name);
        if(flag==true){
            System.out.println();
            display();
        }
        else
            System.out.println("Not Found !!!!");
    }


    void searchNdisplayBetweenQuantity(int search_Quantity){
        if(search_Quantity>=product_Quantity){
            System.out.println("**Products B/W "+ search_Quantity + " Quantity**");
            System.out.println();
            display();
        }
    }


    void searchNdisplayByQuantity(int search_Quantity){
        if(search_Quantity==product_Quantity){
            System.out.println("**Products With Quantity "+ search_Quantity + " **");
            System.out.println();
            display();
        }
    }


    void searchNdisplayBetweenPrice(double search_Price){
        if(search_Price>=product_Price){
            System.out.println("**Products B/W "+ search_Price + " Price**");
            System.out.println();
            display();
        }
    }


    void searchNdisplayByPrice(double search_Price){
        if(search_Price==product_Price){
            System.out.println("**Products With Price "+ search_Price + " **");
            System.out.println();
            display();
        }
    }


    void searchNdisplayByQuality(String search_Quality){
        boolean flag = searchQuality(search_Quality);
        if(flag==true){
            System.out.println();
            display();
        }
        else
            System.out.println("Not Found !!!!");
    }




    void sellProduct(String product_Sell){
        boolean flag = searchID(product_Sell);

        if(product_Quantity==0){
            System.out.println("Sorry, Following Product Is Not Currently Available In Stock :(");
            return;
        }

        if(flag==true){
            System.out.print("Enter Quantity You Wants To Sell : ");
            int sell_Quantity = sc.nextInt();

            while((sell_Quantity>product_Quantity) || sell_Quantity<=0){
                System.out.println("Invalid !!!");
                System.out.print("Enter Quantity You Wants To Sell : ");
                sell_Quantity = sc.nextInt();
            }

            double quality_charge = 0;
            if(product_Quality.equals("A")){
                quality_charge = 2;
            }

            else if(product_Quality.equals("B")){
                quality_charge = 1.75;
            }

            else if(product_Quality.equals("C")){
                quality_charge = 1.5;
            }

            else if(product_Quality.equals("D")){
                quality_charge = 1.25;
            }

            double finalTotal= (sell_Quantity*product_Price)+(sell_Quantity*quality_charge);

            System.out.println("");
            System.out.println("***************************************************************************");
            System.out.println("------------------------------ Grocery Store ------------------------------");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Product Name          Quantity          Price            Total");
            System.out.println("  "+product_Name+"               "+sell_Quantity+"              " + product_Price +"/-          "+(sell_Quantity*product_Price)+"/-" );
            System.out.println();
            System.out.println("Extra Charges (Due to Quality :)                        " + (sell_Quantity*quality_charge));
            System.out.println();
            System.out.println();
            System.out.println("Total Payable                                           " + finalTotal+"/-");
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------- Thank You --------------------------------");
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");


            product_Quantity -= sell_Quantity;
            System.out.println("Product Sold SuccessFull !!!");
            System.out.println();
            System.out.println("Remain Quantity : " + product_Quantity);
            System.out.println();
        }
        else
            System.out.println("Not Found !!!");
    }




    void suppCallsQuantity(){
        if (product_Quantity==0){
            System.out.println();
            System.out.print("Enter Quantity To Add In Product Id " + product_ID + " : ");
            int supp_Quantity = sc.nextInt();

            while(supp_Quantity<=0){
                System.out.println("Invalid !!!");
                System.out.print("Enter Again Quantity : ");
                supp_Quantity = sc.nextInt();
            }

            suppReciept(supp_Quantity);

            product_Quantity += supp_Quantity;

        }
    }


    void suppCallsID(String supp_ID){
        boolean flag = searchID(supp_ID);
        if(flag==true){
            System.out.println();
            System.out.print("Enter Quantity To Add In Product Id " + product_ID + " : ");
            int supp_Quantity = sc.nextInt();

            while(supp_Quantity<=0){
                System.out.println("Invalid !!!");
                System.out.print("Enter Again Quantity : ");
                supp_Quantity = sc.nextInt();
            }
            suppReciept(supp_Quantity);
            product_Quantity += supp_Quantity;
        }
        else
            System.out.println("Not Found !!!");
    }


    void suppCallsName(String supp_Name){
        boolean flag = searchName(supp_Name);
        if(flag==true){
            System.out.println();
            System.out.print("Enter Quantity To Add In Product Id " + product_ID + " : ");
            int supp_Quantity = sc.nextInt();

            while(supp_Quantity<=0){
                System.out.println("Invalid !!!");
                System.out.print("Enter Again Quantity : ");
                supp_Quantity = sc.nextInt();
            }
            suppReciept(supp_Quantity);
            product_Quantity += supp_Quantity;
        }
        else
            System.out.println("Not Found !!!");
    }


    void suppCallsPrice(double supp_Price){
        if(supp_Price==product_Price){
            System.out.println();
            System.out.print("Enter Quantity To Add In Product Id " + product_ID + " : ");
            int supp_Quantity = sc.nextInt();

            while(supp_Quantity<=0){
                System.out.println("Invalid !!!");
                System.out.print("Enter Again Quantity : ");
                supp_Quantity = sc.nextInt();
            }
            suppReciept(supp_Quantity);
            product_Quantity += supp_Quantity;
        }
        else
            System.out.println("Not Found !!!");
    }


    void suppCallsQuality(String supp_Quality){
        boolean flag = searchQuality(supp_Quality);
        if(flag==true){
            System.out.println();
            System.out.print("Enter Quantity To Add In Product Id " + product_ID + " : ");
            int supp_Quantity = sc.nextInt();

            while(supp_Quantity<=0){
                System.out.println("Invalid !!!");
                System.out.print("Enter Again Quantity : ");
                supp_Quantity = sc.nextInt();
            }
            suppReciept(supp_Quantity);
            product_Quantity += supp_Quantity;
        }
        else
            System.out.println("Not Found !!!");
    }


    void suppReciept(int s_Quantity){
        double quality_charge = 0;
        if(product_Quality.equals("A")){
            quality_charge = 1.2;
        }

        else if(product_Quality.equals("B")){
            quality_charge = 0.75;
        }

        else if(product_Quality.equals("C")){
            quality_charge = 0.5;
        }

        else if(product_Quality.equals("D")){
            quality_charge = 0.25;
        }

        double s_Price = (product_Price*80)/100;  //20% Commition

        double finalTotal= (s_Quantity*s_Price)+(s_Quantity*quality_charge);

        System.out.println("");
        System.out.println("***************************************************************************");
        System.out.println("----------------------------- Supplier Reciept ----------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Product Name          Quantity          Price            Total");
        System.out.println("  "+product_Name+"               "+s_Quantity+"              " + product_Price +"/-          "+(s_Quantity*s_Price)+"/-" );
        System.out.println();
        System.out.println("Extra Charges (Due to Quality :)                        " + (s_Quantity*quality_charge));
        System.out.println();
        System.out.println();
        System.out.println("Total Payable                                           " + finalTotal+"/-");
        System.out.println();
        System.out.println();
        System.out.println("-------------------------------- Thank You --------------------------------");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(" * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

    }



    boolean isInteger(String n){
        for(int i=0; i<n.length(); i++){
            if((n.charAt(i)>='A' && n.charAt(i)<='Z') || (n.charAt(i)>='a' && n.charAt(i)<='z')){
                System.out.println("Invalid Formate !!! ");
                System.out.println();
                return false;
            }
        }
        return true;
    }


    boolean isValidName(String n){

        if(n.charAt(0)<'A' || n.charAt(0)>'Z'){
            System.out.println("Invalid Formate !!!");
            System.out.println("Please keep First Letter in Caps and Others In Small Case.");
            System.out.println();
            return false;
        }
        else{
            for(int i=1; i<n.length(); i++){
                if(n.charAt(i)<'a' || n.charAt(i)>'z'){
                    System.out.println("Invalid Formate !!!");
                    System.out.println("Please keep First Letter in Caps and Others In Small Case.");
                    System.out.println();
                    return false;
                }
            }
            return true;
        }
    }


    boolean isValidQuality(String n){
        if(n.length()==1){
            if(n.charAt(0) < 'A' || n.charAt(0) > 'E'){
                System.out.println("Invalid Formate !!!");
                System.out.println("Valid Formate : A / B / C / D / E");
                System.out.println();
                return false;
            }
            else{
                return true;
            }
        }
        else{
            System.out.println("Invalid Formate !!!");
            System.out.println("1.Valid Formate : A / B / C / D / E");
            System.out.println();
            return false;
        }
    }



    boolean searchID(String id){
        if(id.equals(product_ID))
            return true;
        else
            return false;
    }


    boolean searchName(String Name){
        if(Name.equalsIgnoreCase(product_Name))
            return true;
        else
            return false;
    }


    boolean searchQuality(String Quality){
        if(Quality.equalsIgnoreCase(product_Quality))
            return true;
        else
            return false;
    }
}

class Run{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int choice=0, product_count=0;

        System.out.println("********************************************************");
        System.out.println("********************************************************");
        System.out.println("                      Hello User....");
        System.out.println("      Welcome To Grocery Store Management System");
        System.out.println("*******************************************************");
        System.out.println("*******************************************************");
        System.out.println();
        System.out.print("Enter Total Number Of Product : ");
        int size = sc.nextInt();
        StoreManagementSystem s[] = new StoreManagementSystem[size];

        System.out.println();
        do{
            System.out.println();
            System.out.println("******************************************");
            System.out.println("******************************************");
            System.out.println("**** Choose Your Choice *****");
            System.out.println();
            System.out.println("Press 1 To Add Product Catalog.");
            System.out.println("Press 2 To Display Product Catalog.");
            System.out.println("Press 3 To Update Product Catalog.");
            System.out.println("Press 4 To Search Product Catalog.");
            System.out.println("Press 5 To Sell Product.");
            System.out.println("Press 6 To Call Supplier.");
            System.out.println("Press 7 To Exit From System.");
            System.out.println();
            System.out.print("Enter Your Choice : ");
            choice = sc.nextInt();
            System.out.println();

            switch(choice){

                case 1 :
                    if(product_count<size){
                        for(int i=0; i<s.length; i++){
                            s[i] = new StoreManagementSystem();
                            System.out.println("**** Enter Details Of Product No.  " + (product_count+1) + " ****");
                            s[i].setData();
                            product_count++;
                        }
                    }

                    else
                        System.out.println("Sorry, DataBase Is Full !!!");

                    break;

                case 2 :
                    System.out.println("          ********************************************");
                    System.out.println("          ************** Displaying Data *************");
                    System.out.println("          ********************************************");
                    System.out.println();
                    if(product_count>0){
                        for(int i=0; i<size; i++){
                            System.out.println("                 *****************************");
                            System.out.println("                  ***Details Of Product " + (i+1) + " ***");
                            s[i].display();
                        }
                    }
                    else
                        System.out.println("Data base is empty !!!");

                    break;

                case 3 : System.out.println("*** Updation ***");
                    System.out.println("***************************");
                    System.out.println();
                    System.out.print("Enter Product ID : ");
                    String updt_ID = sc.next();
                    System.out.println();
                    for(int i = 0; i<size; i++){
                        s[i].updateData(updt_ID);
                    }


                    break;


                case 4 : System.out.println("***Search***");
                    System.out.println("***************************");
                    System.out.println();
                    int search_choice=0;
                    System.out.println("****Choices****");
                    System.out.println();
                    System.out.println("Press 1 To Search By Product ID.");
                    System.out.println("Press 2 To Search By Product Name.");
                    System.out.println("Press 3 To Search By Product Quantity.");
                    System.out.println("Press 4 To Search By Product Price.");
                    System.out.println("Press 5 To Search By Product Quality.");
                    System.out.println();
                    System.out.print("Enter Your Choice : ");
                    search_choice = sc.nextInt();
                    System.out.println();

                    switch(search_choice){
                        case 1 :
                            System.out.print("Enter Search ID : ");
                            String search_ID = sc.next();

                            for(int i = 0; i<size; i++){
                                s[i].searchNdisplayByID(search_ID);
                            }

                            break;

                        case 2 :
                            System.out.print("Enter Search Name : ");
                            String search_Name = sc.next();

                            for(int i = 0; i<size; i++){
                                s[i].searchNdisplayByName(search_Name);
                            }

                            break;

                        case 3 : int search_Quantity = 0;
                            do{
                                System.out.print("Enter Search Quantity : ");
                                search_Quantity = sc.nextInt();
                            }while(search_Quantity<0);

                            System.out.println();
                            System.out.println("Press 1 To Display All Products B/W Entered Quantity.");
                            System.out.println("Press 2 To Display Specific Entered Quantity.");
                            System.out.print("Enter Your Choice : ");
                            int quantity_choice = sc.nextInt();
                            switch(quantity_choice){
                                case 1 :
                                    for(int i = 0; i<size; i++){
                                        s[i].searchNdisplayBetweenQuantity(search_Quantity);
                                    }
                                    break;

                                case 2 :
                                    for(int i = 0; i<size; i++){
                                        s[i].searchNdisplayByQuantity(search_Quantity);
                                    }
                                    break;

                                default : System.out.println("Invalid Parameter !!!");
                            }

                            break;

                        case 4 : double search_Price = 0.0;
                            do{
                                System.out.print("Enter Search Price : ");
                                search_Price = sc.nextDouble();
                            }while(search_Price<0.0);

                            System.out.println();
                            System.out.println("Press 1 To Display All Products B/W Entered Price.");
                            System.out.println("Press 2 To Display Specific Entered Price.");
                            System.out.print("Enter Your Choice : ");
                            int price_choice = sc.nextInt();
                            switch(price_choice){
                                case 1 :
                                    for(int i = 0; i<size; i++){
                                        s[i].searchNdisplayBetweenPrice(search_Price);
                                    }
                                    break;

                                case 2 :
                                    for(int i = 0; i<size; i++){
                                        s[i].searchNdisplayByPrice(search_Price);
                                    }
                                    break;

                                default : System.out.println("Invalid Parameter !!!");
                            }

                            break;

                        case 5 :
                            System.out.print("Enter Search Quality : ");
                            String search_Quality = sc.next();

                            for(int i = 0; i<size; i++){
                                s[i].searchNdisplayByQuality(search_Quality);
                            }

                            break;

                        default : System.out.println("Invalid Parameter !!!!");
                    }

                    break;

                case 5 :
                    System.out.print("Enter ID Of Product You Wants To Sell : ");
                    String product_Sell = sc.next();
                    for(int i = 0; i<size; i++){
                        s[i].sellProduct(product_Sell);
                    }
                    break;

                case 6 :
                    System.out.println("### Supplier Portal ###");
                    System.out.println();
                    System.out.println("Press 1 To Add Quantity Which Product Have 0 Quantity.");
                    System.out.println("Press 2 To Add Quantity By ID.");
                    System.out.println("Press 3 To Add Quantity By Name.");
                    System.out.println("Press 4 To Add Quantity By Price.");
                    System.out.println("Press 5 To Add Quantity By Quality.");
                    System.out.println();
                    System.out.print("Enter Your Choice : ");
                    int supp_choice = sc.nextInt();

                    switch(supp_choice){
                        case 1 :
                            for(int i=0; i<size; i++){
                                s[i].suppCallsQuantity();
                            }
                            break;

                        case 2 :
                            System.out.print("Enter Id : ");
                            String supp_ID = sc.next();
                            for(int i=0; i<size; i++){
                                s[i].suppCallsID(supp_ID);
                            }

                            break;

                        case 3 :
                            System.out.print("Enter Name : ");
                            String supp_Name = sc.next();
                            for(int i=0; i<size; i++){
                                s[i].suppCallsName(supp_Name);
                            }

                            break;

                        case 4 :
                            System.out.print("Enter Price : ");
                            double supp_Price = sc.nextDouble();

                            for(int i=0; i<size; i++){
                                s[i].suppCallsPrice(supp_Price);
                            }

                            break;

                        case 5 :
                            System.out.print("Enter Quality : ");
                            String supp_Quality = sc.next();
                            for(int i=0; i<size; i++){
                                s[i].suppCallsQuality(supp_Quality);
                            }

                            break;

                        default : System.out.println("Invalid Parameter.");

                    }

                    break;

                case 7 :System.out.println("Thanks For Visiting....");
                    System.out.println("Exiting....");
                    System.exit(0);

                    break;

                default : System.out.println("Invalid Parameter !!!!");

            }
        }while(choice!=7);
    }
}
