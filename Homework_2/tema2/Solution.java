package tema2;

import java.util.Arrays;

/**
 * Retains the solution for the Room Assignment Problem.
 */
public class Solution {
    /**
     * retains what room received the event with a specific index
     */
    private Room[] assignment;

    /**
     * Setter for a solution of the problem.
     *
     * @param assignment retains what room received the event with a specific index
     */
    public void setAssignment(Room[] assignment) {
        this.assignment = assignment;
    }

    /**
     * Returns the number of used rooms in the solution.
     *
     * @return the number of used rooms in the solution
     */
    public int computeUsedRooms() {
        int usedRooms = 1;
        for (int i = 1; i < assignment.length; i++)
            if (!sameRoom(i))
                usedRooms++;
        return usedRooms;
    }

    /**
     * Verifies if the room with the given index has not already appeared before in the solution representation.
     *
     * @param index an index of a room
     * @return true/false
     */
    public boolean sameRoom(int index) {
        for (int i = 0; i < index; i++)
            if (assignment[i].equals(assignment[index]))
                return true;
        return false;
    }

    /**
     * @return the properties of the solution
     */
    @Override
    public String toString() {
        return "Solution: " + Arrays.toString(assignment);
    }
}
