import java.util.*;
public class Board {

    private ArrayList<Marks> bd;
    public int won;
    public Board() {
	won = 0;
	bd = new ArrayList<Marks>(15);
	for(int i = 0; i < 9; i++)
	    { bd.add(new Marks(0));}
    }

    public boolean isGame() {
	for(int j = 0; j < 3; j++) {
	    if(bd.get(j).getPlayer() == bd.get(j+3).getPlayer() && bd.get(j).getPlayer() == bd.get(j+6).getPlayer() && bd.get(j).getPlayer() != 0) {
	won = bd.get(j).getPlayer(); return true;}
	}
	for(int i = 0; i < 9; i+= 3) {
	    if(bd.get(i).getPlayer() == bd.get(i+1).getPlayer() && bd.get(i).getPlayer() == bd.get(i+2).getPlayer() && bd.get(i).getPlayer() != 0) { 
		won = bd.get(i).getPlayer(); return true;}
	}
	if(bd.get(0).getPlayer() == bd.get(4).getPlayer() && bd.get(0).getPlayer() == bd.get(8).getPlayer() && bd.get(0).getPlayer() !=0) {
	    won = bd.get(0).getPlayer(); return true;}
	else if(bd.get(2).getPlayer() == bd.get(4).getPlayer() && bd.get(2).getPlayer() == bd.get(6).getPlayer() && bd.get(2).getPlayer() !=0) {
	    won = bd.get(2).getPlayer(); return true;}
	else {
	    for(int l = 0; l < 9; l++) {
		if(bd.get(l).getPlayer() == 0) {return false;}
	    }
	    won = 3;
	    return true;
	}
    } 
    
    public int move(int play) {
	if(this.isGame()) {return 9;}
	int place = (int)(Math.random() * 9);
	while(bd.get(place).getPlayer() != 0) {
	    place = (int)(Math.random() * 9);
	}
	bd.get(place).setPlayer(play);
	this.isGame();
	return place;
    }
	

    public void printBoard() {
	int index = 0;
	for(int i = 0; i < 9; i++){
	    if(i == 8) {System.out.print(bd.get(i).toString());}
	    else if(i % 3 == 2) {
		System.out.println(bd.get(i).toString());
		 System.out.println(" -------");
	    }
	    else {System.out.print(bd.get(i).toString() + " | ");}	
	}
	System.out.println();
	System.out.println();
    }


    public String toString() {
	String str = "";
	for(int i = 0; i < 9; i++){
            if(i == 8) {str += bd.get(i).toString() + "\n \n";}
            else if(i % 3 == 2) {
		str += bd.get(i).toString();
		str += "\n -------- \n";
            }
            else {
		str += bd.get(i).toString() + " | ";}
	    
        }
	return str;
    }

    
    public static void main(String[] args) {
	Board board = new Board();
	System.out.print(board.toString());
	int player = 1;
	while(board.won == 0)
	    {
		board.move(player);
		System.out.println(board.toString());
		if(player == 1) { player = 2;}
		else{player = 1;}
	    }
	System.out.println("Final Board");
	System.out.println();
	System.out.println(board.toString());
	System.out.println("Game is over: " + board.won);
    }
 
}