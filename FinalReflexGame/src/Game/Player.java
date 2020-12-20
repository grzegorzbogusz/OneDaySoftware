package Game;

public class Player {

    private int score;
    private int record;
    private int misses;

    public Player() {
        this.score = 0;
        this.record = 0;
        this.misses = 0;
    }

    public void resetStats() {
        this.score = 0;
        this.misses = 0;
    }

    public int getScore() { return this.score; }

    public int getRecord() { return this.record; }

    public int getMisses() { return this.misses; }

    public void setScore(int points) { this.score+=points; }

    public void countMisses() { this.misses++; }

    public void setNewRecord() {
        if(this.score > this.record)
            this.record = this.score;
    }



}
