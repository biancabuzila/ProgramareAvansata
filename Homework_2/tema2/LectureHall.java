package tema2;

public class LectureHall extends Room {
    /**
     * indicates if there is a video projector in the room or not
     */
    private boolean videoProjector;

    /**
     * Constructor
     */
    public LectureHall() {
    }

    ;

    /**
     * Constructor that sets the value for videoProjector.
     *
     * @param videoProjector indicates if there is a video projector in the room or not
     */
    public LectureHall(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    /**
     * Getter of the existence of a video projector.
     *
     * @return the value of videoProjector
     */
    public boolean isVideoProjector() {
        return videoProjector;
    }

    /**
     * Setter for the existence of a video projector.
     *
     * @param videoProjector indicates if there is a video projector in the room or not
     */
    public void setVideoProjector(boolean videoProjector) {
        this.videoProjector = videoProjector;
    }

    /**
     * @return the properties of the object
     */
    @Override
    public String toString() {
        return name + "(cap=" + capacity + ", lecture hall)";
    }
}
