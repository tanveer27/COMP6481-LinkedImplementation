import java.util.Arrays;
import java.util.Scanner;

/**
 * Name and ID: Tanveer Reza
 * Assignment # 2
 * Question: 2
 * Due Date: 09/11/2024
 * The Participant class represents a participant in the competition with their ID, name, and Diya collection.
 */
public class Participant {

    private String participantID;
    private String participantName;
    private int[] diyaCollection;

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2(a)
     * A parameterized Constructor for participant.
     * @param participantID the ID of the participant
     * @param participantName the name of the participant
     * @param diyaCollection the Diya collection of the participant
     */
    public Participant(String participantID, String participantName, int[] diyaCollection) {
        this.participantID = participantID;
        this.participantName = participantName;
        this.diyaCollection = diyaCollection;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2(b)
     *  Constructs a new Participant by copying another participant and assigning a new ID.
     * @param participantObject the participant to copy
     * @param newParticipantID the new ID for the participant
     */
    public Participant(Participant participantObject, String newParticipantID) {
        this.participantID = newParticipantID;
        this.participantName = participantObject.participantName;
        this.diyaCollection = participantObject.diyaCollection.clone();
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2(c)
     * Creates and returns a clone of this participant with a new ID scanned from user.
     * @return a clone of this participant with a new ID
     */
    @Override
    public Participant clone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new participant ID: ");
        String newParticipantID = scanner.nextLine();
        return new Participant(this, newParticipantID);
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Sets the ID of the participant.
     * @param participantID the new ID of the participant
     */
    public void setParticipantID(String participantID) {
        this.participantID = participantID;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Gets the ID of the participant.
     * @return the ID of the participant
     */
    public String getParticipantID() {
        return participantID;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Sets the name of the participant.
     * @param participantName the new name of the participant
     */
    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Gets the name of the participant.
     * @return the name of the participant
     */
    public String getParticipantName() {
        return participantName;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Sets the Diya collection of the participant.
     * @param diyaCollection the new Diya collection of the participant
     */
    public void setDiyaCollection(int[] diyaCollection) {
        this.diyaCollection = diyaCollection.clone(); // To avoid shallow copy
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Gets the Diya collection of the participant.
     * @return a copy of the Diya collection of the participant
     */
    public int[] getDiyaCollection() {
        return diyaCollection.clone(); // To avoid exposing internal array
    }

    /**
     *  Written by: Tanveer Reza 40292971
     * Calculates and returns the total decorative values of the participant's Diya collection.
     * @return the total decorative values of the Diya collection
     */
    public int getDecorativeValues() {
        return diyaCollection[0] * Diya.STARRY_NIGHT.getDecorativeValue()
                + diyaCollection[1] * Diya.LOTUS_BLOSSOM.getDecorativeValue()
                + diyaCollection[2] * Diya.OCEAN_WAVE.getDecorativeValue()
                + diyaCollection[3] * Diya.SUNSET_GLOW.getDecorativeValue()
                + diyaCollection[4] * Diya.MYSTIC_FOREST.getDecorativeValue();
    }

    /**
     *  Written by: Tanveer Reza 40292971
     * Calculates and returns the total material cost of the participant's Diya collection.
     * @return the total material cost of the Diya collection
     */
    public double getMaterialCost() {
        return diyaCollection[0] * Diya.STARRY_NIGHT.getMaterialCost()
                + diyaCollection[1] * Diya.LOTUS_BLOSSOM.getMaterialCost()
                + diyaCollection[2] * Diya.OCEAN_WAVE.getMaterialCost()
                + diyaCollection[3] * Diya.SUNSET_GLOW.getMaterialCost()
                + diyaCollection[4] * Diya.MYSTIC_FOREST.getMaterialCost();
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2 (d)
     * Returns a string representation of the participant.
     * @return a string representation of the participant
     */
    @Override
    public String toString() {
        return "Participant ID: " + participantID +
                ", Participant Name: " + participantName +
                ", Diya Collection: " + Arrays.toString(diyaCollection);
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2 (d)
     * Compares this participant to the specified object. The result is true if and only if the argument is not null and is a Participant object that has the same name and Diya collection as this object.
     * @param obj the object to compare this Participant against
     * @return true if the given object represents a Participant equivalent to this participant, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Participant participantToCompare = (Participant) obj;
        return participantName.equals(participantToCompare.participantName) &&
                Arrays.equals(diyaCollection, participantToCompare.diyaCollection);
    }
}