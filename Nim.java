/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nim;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tiegancozzie
 */

public class Nim {
    
    Random rand=new Random();
    
    
    public int easyPlay(int marbles, int move){
        Scanner userInput= new Scanner(System.in);
  
        if (move==1){
            int takeAway = rand.nextInt(0,(marbles/2))+1;
            marbles-=takeAway;
            System.out.println("Computer takes away "+takeAway+" marbles");
            move=0;
        }
        while (marbles!=1){
            if (marbles!=1){
            System.out.println("There are "+marbles+ " marbles in the stack.");
            System.out.println("You can take between 1 and "+(marbles/2)+" marbles");
            System.out.println("How many marbles would you like to take?");
            
            int userNum=userInput.nextInt();
            while((userNum<1) || (userNum>(marbles/2))){
            System.out.println("Sorry that is not a valid answer. Try again");
            userNum=userInput.nextInt();
            }
            marbles-=userNum;
            move=1;
            }else{
                return move;
            }
            if (marbles!=1){
            System.out.println("There are "+marbles+" left.");
            int takeAway = rand.nextInt(0,(marbles/2))+1;
            marbles-=takeAway;
            System.out.println("Computer takes away "+takeAway+" marbles");
            move=0;
            }else{
                return move;
            }
            
      }
        return move;   
    }
    
    public int hardPlay(int marbles, int move){
        Scanner userInput= new Scanner(System.in);
        int takeAway=2;
        int count=0;
        
       
        if (move==1){
            do{
                takeAway=2;
                count++;
                takeAway=(int) Math.pow(takeAway,count);
            }while(takeAway<=(marbles/2));
            takeAway-=1;
            takeAway=marbles-takeAway;
            marbles-=takeAway;
            System.out.println("Computer takes away "+takeAway+" marbles");
            move=0;
            
        }
        while (marbles!=1){
            count=0;
            if (marbles!=1){
            System.out.println("There are "+marbles+ " marbles in the stack.");
            System.out.println("You can take between 1 and "+(marbles/2)+" marbles");
            System.out.println("How many marbles would you like to take?");
            
            int userNum=userInput.nextInt();
            while((userNum<1) || (userNum>(marbles/2))){
            System.out.println("Sorry that is not a valid answer. Try again");
            userNum=userInput.nextInt();
            }
            marbles-=userNum;
            move=1;
            }else{
                return move;
            }
            if (marbles!=1){
            System.out.println("There are "+marbles+" left.");
            
            if (move==1){
                do{
                takeAway=2;
                count++;
                takeAway=(int) Math.pow(takeAway,count);
            }while(takeAway<=(marbles/2));
            takeAway-=1;
            takeAway=marbles-takeAway;
            if(marbles/2<takeAway){ 
                takeAway=rand.nextInt(1,(marbles/2)+1);
            }
            marbles-=takeAway;
            System.out.println("Computer takes away "+takeAway+" marbles");
            move=0;
            }else{
                return move;
            }
            
      }
           
    }
        return move;
        
    }
   
    
    public void play(){
        int marbles;
        int firstMove;
        int compDiff;
        int outcome;
        
        marbles=rand.nextInt(10,101);
        firstMove=rand.nextInt(0,2);
        compDiff=rand.nextInt(0,2);
        
        System.out.println("The Starting amount of marbles will be: "+marbles);
        if(firstMove==0){
            System.out.println("Human goes first");
        } else{
            System.out.println("Computer goes first");
        }
      
        if (compDiff==0){
            outcome=this.easyPlay(marbles,firstMove);
        }else{
            outcome=this.hardPlay(marbles,firstMove);
        }
        
        if (outcome==1){
            System.out.println("Human Wins!");
        }else{
            System.out.println("Computer Wins!");
        }
    }
    
    public static void main(String[] args) {
        Nim rand1=new Nim();
        rand1.play();
    }
    
}
