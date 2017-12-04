package com.chess.model.pieces;

import com.chess.model.Board;
import com.chess.model.Cell;
import com.chess.util.Color;
import com.chess.util.Move;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan.hrynchyshyn on 17.11.2017.
 */

public abstract class Piece {

    private Color color;
    private String id;
    protected Cell currentCell;
    protected Cell defaultCell;
    private boolean available; // not dead
    protected List<String> availableCellsToMove = new ArrayList<>();


    public Piece(Color color, String id, boolean available) {
        this.color = color;
        this.id = id;
        this.available = available;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Cell getDefaultCell() {
        return defaultCell;
    }

    public void setDefaultCell(Cell defaultCell) {
        this.defaultCell = defaultCell;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<String> getAvailableCellsToMove() {
        return availableCellsToMove;
    }

    public void setAvailableCellsToMove(List<String> availableCellsToMove) {
        this.availableCellsToMove = availableCellsToMove;
    }

    /**
     * @return destination Cell

     */
    public abstract Cell move(Board board, Cell destinationCell); /**state is board state in current time; */
    public  List<String> getAvailableCellsToMove(Board board){
        return null;
    }; /**state is board state in current time; */


}
