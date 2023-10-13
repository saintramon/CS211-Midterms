/**
 * NAME: JASMIN, Ramon Emmiel P.
 * DATE: 13 September 2023
 */
public class MazeCell {
    private int row;
    private int column;

    public MazeCell(){
        this.row = 0;
        this.column = 0;
    }
    public MazeCell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean sameAs(MazeCell another){
        return (row == another.getRow() && column == another.getColumn());
    }
}
