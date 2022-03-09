package tema2;

/**
 * Describes the algorithm that solves the Room Assignment Problem for a given instance.
 */
public class Algorithm {
    /**
     * an instance of the Room Assignment Problem
     */
    private Problem pb;

    /**
     * Constructor that sets the instance problem
     *
     * @param pb an instance of the Room Assignment Problem
     */
    public Algorithm(Problem pb) {
        this.pb = pb;
    }

    /**
     * Solves the Room Assignment Problem for the given instance
     *
     * @return the solution of the problem
     */
    public Solution solve() {
        Room[] assignment = new Room[pb.getNrEvents()];
        boolean[][] schedule = new boolean[pb.getNrRooms()][24];

        for (int i = 0; i < pb.getNrEvents(); i++)
            for (int j = 0; j < pb.getNrRooms(); j++)
                if (pb.getEvent(i).getSize() <= pb.getRoom(j).getCapacity() && free(i, j, schedule)) {
                    assignment[i] = pb.getRoom(j);
                    for (int k = pb.getEvent(i).getStart(); k < pb.getEvent(i).getEnd(); k++)
                        schedule[j][k] = true;
                    break;
                }

        Solution sol = new Solution();
        sol.setAssignment(assignment);
        return sol;
    }

    /**
     * Verifies if a certain room is free when a given event takes place
     *
     * @param eventIndex the index of the event
     * @param roomIndex  the index of the room
     * @param schedule   the array that retains the free/occupied hours of a room
     * @return true if the room with the given index is free when the event with the given index takes place
     */
    public boolean free(int eventIndex, int roomIndex, boolean[][] schedule) {
        for (int i = pb.getEvent(eventIndex).getStart(); i < pb.getEvent(eventIndex).getEnd(); i++)
            if (schedule[roomIndex][i])
                return false;
        return true;
    }
}
