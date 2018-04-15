public class Marks {

    public String mark;
    public int player;
    public Marks(int player){
	this.player = player;
	changeMark();
    }

    public void changeMark(){
	if(player == 0) {mark = " ";}
	else if(player == 1) {mark = "o";}
	else {mark = "x";}
    }

    public int getPlayer() {
	return player;
    }

    public void setPlayer(int player) {
	this.player = player;
	changeMark();
    }
    public String toString() {
	return mark;
    }
}