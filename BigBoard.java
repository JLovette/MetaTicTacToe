import java.util.*;
public class BigBoard {

    private ArrayList<Board> boards;

    public BigBoard() {
	boards = new ArrayList<Board>();
	for(int i = 0; i < 9; i++) {
	    boards.add(new Board()); 
	}
    }
    
    public int move(int location, int player){
	if(location == 9) {
	    return move(0,player);
	}
	if(boards.get(location).won == 3) {
	    location = (int)(Math.random() * 9);
	    return move(location, player);
	}
	else {
	    return boards.get(location).move(player);
	}
    }

    public boolean isWon() {
	//Checks for vertical wins
	for(int i = 0; i < 3; i++) {
	    if(boards.get(i).won == boards.get(i+3).won && boards.get(i).won == boards.get(i+6).won && (boards.get(i).won == 1 || boards.get(i).won == 2))
		{
		    System.out.println("Player " + boards.get(i).won + " won");
		    return true;
		}
	}
	//Checks for horizontal wins
	for(int i = 0; i < 9; i+=3) {
	    if(boards.get(i).won == boards.get(i+1).won && boards.get(i).won == boards.get(i+2).won && (boards.get(i).won == 1 || boards.get(i).won == 2))
		{
		    System.out.println("Player " + boards.get(i).won + " won");
		    return true;
		}
	}
	//Right wins
	if(boards.get(0).won == boards.get(4).won && boards.get(0).won == boards.get(8).won && (boards.get(0).won == 1 || boards.get(0).won == 2)) 
	    {
		return true;
	    }
	//Left wins
	else if(boards.get(2).won == boards.get(4).won && boards.get(2).won == boards.get(6).won && (boards.get(2).won == 1 || boards.get(2).won == 2))
	    {
		return true;
	    }
	else 
	    {
		for(int j = 0; j < 9; j++) {
		    if(boards.get(j).won != 3) 
			{ return false;}
		}
		System.out.println("Draw");
		return true;
	    }
    }

    public String toString() {
	String str = "";
        for(int i = 0; i < 9; i++){
            if(i == 8) {str += boards.get(i).toString() + "\n \n";}
            else if(i % 3 == 2) {
                str += boards.get(i).toString();
                str += "\n ---------------- \n";
            }
            else {
                str += boards.get(i).toString() + " | ";}

        }
        return str;
    }
    
    public void printBoard() {
	for(int i = 0; i < 9; i++)
	    {
		boards.get(i).printBoard();
	    }
    }


    public static void main(String[] args)
    {
	int player = 1;
	int location = 0;
	BigBoard b = new BigBoard();
	b.printBoard();

	while(b.isWon() == false)
	    {
		location = b.move(location, player);
		if(player == 1) {player = 2;}
		else {player = 1;}
		b.printBoard();
	    }
    }
}
