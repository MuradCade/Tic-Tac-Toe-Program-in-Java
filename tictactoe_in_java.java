import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
class Main {  

static ArrayList<Integer> playerPositions =  new ArrayList<Integer>();
static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();


    
  public static void main(String args[]) { 
 
 char [][] gameboard = {
     {' ', '|', ' ', '|', ' '},
     {'-', '+', '-', '+', '-'},
     {' ', '|', ' ', '|', ' '},
     {'-', '+', '-', '+', '-'},
     {' ', '|', ' ', '|', ' '}
 } ;
 
 
printboard(gameboard);
Scanner scan = new Scanner (System.in);
while(true){
System.out.println("Enter Your Placement (1-9): ");
int pos = scan.nextInt();
while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)){
System.out.println("Place Is Taken Chose Another Place");
playerPos = scan.nextInt();


pos(gameboard , pos, "player");
Random ran = new Random();
int cpupos = ran.nextInt(9)+1;
pos(gameboard, cpupos, "cpu");
printboard(gameboard);
String result = checkwinner();
System.out.print(result);
      
      } 
  }
      
      public static void printboard(char [][] gameboard){
          
          for(char [] row : gameboard){
        for(char c : row){
            System.out.print(c);
        }
        System.out.println();
    }
}

public static void pos(char [] [] gameboard , int pos, String user){
    char symbol = ' ';
    if(user.equals("player")){
        symbol = 'x';
        playerPositions.add(pos);
    }
    
    else if(user.equals("cpu")){
        symbol = 'o';
        cpuPositions.add(pos);
    }
    
switch(pos){
case 1:
gameboard [0][0] = symbol;
break;

case 2:
gameboard [0][2] = symbol;
break;

case 3:
gameboard [0][4] = symbol;
break;

case 4:
gameboard [2][0] = symbol;
break;

case 5:
gameboard [2][2] = symbol;
break;

case 6:
gameboard [2][4] = symbol;
break;

case 7:
gameboard [4][2] = symbol;
break;

case 8:
gameboard [4][4] = symbol;
break;

case 9:
gameboard [0][0] = symbol;
break;
default:
break;
}

} 
public static String checkwinner(){

List toprow = Arrays.asList(1,2,3);
List midrow = Arrays.asList(4,5,6);
List botrow = Arrays.asList(8,7,9);

List leftcol = Arrays.asList(1,4,7);
List midcol = Arrays.asList(2,5,6);
List rightcol = Arrays.asList(3,6,9);


List cross1 = Arrays.asList(1,5,9);
List cross2 = Arrays.asList(7,5,3);





List<List> winning = new ArrayList<List>();


winning.add(toprow);
winning.add(midrow);
winning.add(botrow);
winning.add(leftcol);
winning.add(midcol);
winning.add(rightcol);
winning.add(cross1);
winning.add(cross2);

for(List L: winning){  
   if(playerPositions.containsAll(L)){
     return "Congrats You Win!";
}
else if(cpuPositions.containsAll(L)){
return " Computer Wins !";
}
else if(playerPositions.size() + cpuPositions.size() ==9){
 return "No One Win Tie";
}
 }
return "";
    
}







    
    
}
    

