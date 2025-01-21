public class SurvivorLeader {

    Shelter[] shelters = new Shelter[40];

    private String transmission = "q2xf1t8r5w3t tm9c5i8l900d5n7heto 3g5t6hgw44y5e7bhty605rh8t5 85ml95ak2k5r7qw5ksp295e5t7p45 o5i3n 6z5n205 9soe5o8hhg5lygtt5dq7th 5 gf34s9o 35j7j5o45k99hg5kyqqcjg5mkpl20z5o629sle5k20sk5k9c5 gh73h qxp25vi8t5i3f2v1q 9x7z6t5l8r9j3o4v5l3l1w 9y5a4d6f7x2c9l5g h8s45ek6";

    public static void main(String[] args) {
        SurvivorLeader it = new SurvivorLeader();
    }

    public SurvivorLeader(){
        System.out.println("Goodbye World! Good luck surviving the apocalypse!");

        for(int x=0;x< shelters.length;x++){
            int n = (int)((Math.random()*100)+1);
            int m = (int)(Math.random()*1001);
            shelters[x] = new Shelter(n,m);
        }

        displayShelters();
        System.out.println();
        System.out.println("it is " + checkSupplies() + " that at least 2 numbers of supplies are equal");
        System.out.println();
        System.out.println("The transmission says: " + decipher(transmission));

        newDefense();
    }

    public void displayShelters(){
        for(int x=0;x< shelters.length;x++){
            System.out.println("Shelter #: " + (x+1));
            shelters[x].printInfo();
        }
    }

    public boolean checkSupplies(){
        for(int x=0;x< shelters.length;x++){
            for(int i=0;i< shelters.length;i++){
                if(x!=i && shelters[x].getNumberOfSupplies()==shelters[i].getNumberOfSupplies()){
                    return true;
                }
            }
        }

        return false;
    }

    public String decipher(String message){
        String decoded = "";
        while(message.contains("5")){
            int num = message.indexOf("5");
            String letter = message.substring(num+1, num+2);
            decoded += letter;
            message = message.substring(num+1);
        }

        return decoded;
    }

    //I'm not really sure what I'm doing but what I tried to do was make a method that if
    // checkSupplies was true would reset all the defense levels to something new
    //and then if that new thing also made checkSupplies true then it would rerun the method
    //until checkSupplies was false and I'm pretty sure it is rerunning but it has never
    //displayed shelters so I don't think its successfully getting to that part and instead
    //I'm getting some weird errors


    public void newDefense(){
        checkSupplies();
            if(checkSupplies()==true){
                for(int x=0;x< shelters.length;x++) {
                    int n = (int) ((Math.random() * 100) + 1);
                    shelters[x].setDefenseLevel(n);
                }
                checkSupplies();
                if(checkSupplies()==true){
                    newDefense();
                }else{
                    displayShelters();
                }
            }
        }
    }

