//snakeGame: Functionalities
//Move,
// crosses it self->game over,
// Food ->at given interval
// Classes --> Snake, Cell, Board, Game
// To represent a cell of display board.
public class Cell {
 
    private final int row, col;
    private CellType cellType;
 
    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
 
    public CellType getCellType()
    {
        return cellType;
    }
 
    public void setCellType(CellType cellType)
    {
        this.cellType = cellType;
    }
 
    public int getRow()
    {
        return row;
    }
 
    public int getCol()
    {
        return col;
    }
}


//enums for state of a cell
public enum CellType {
 
    EMPTY,
    FOOD,
    SNAKE_NODE;
}

import java.util.LinkedList; 
public class Snake {
 
    private LinkedList<Cell> snakePartList
        = new LinkedList<>();
    private Cell head;
 
    public Snake(Cell initPos)
    {
        head = initPos;
        snakePartList.add(head);
        head.setCellType(CellType.SNAKE_NODE);
    }
 
    public void grow() { snakePartList.add(head); }
 
    public void move(Cell nextCell)
    {
        System.out.println("Snake is moving to "
                           + nextCell.getRow() + " "
                           + nextCell.getCol());
        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);
 
        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePartList.addFirst(head);
    }
 
    public boolean checkCrash(Cell nextCell)
    {
        System.out.println("Going to check for Crash");
        for (Cell cell : snakePartList) {
            if (cell == nextCell) {
                return true;
            }
        }
 
        return false;
    }
 
    public LinkedList<Cell> getSnakePartList()
    {
        return snakePartList;
    }
 
    public void
    setSnakePartList(LinkedList<Cell> snakePartList)
    {
        this.snakePartList = snakePartList;
    }
 
    public Cell getHead() { return head; }
 
    public void setHead(Cell head) { this.head = head; }
}
