import java.util.ArrayList;
import java.util.Comparator;

/**
 * Name and ID: Tanveer Reza
 * Assignment # 2
 * Due Date: 09/11/2024
 * The CompetitionResults class manages the participants and their results in a competition.
 * It maintains a list of all participants and a list of the top three participants.
 */
public class CompetitionResults implements Lightable {
    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 4 (a)
     * The list of all participants in the competition.
     */
    private final ParticipantList allParticipants;
    private ParticipantList topThreeList;

    /**
     *   Written by: Tanveer Reza 40292971
     *   Assignment 2
     *   Question: 4 (a)
     * Constructs a new CompetitionResults object with empty participant lists.
     */
    public CompetitionResults() {
        this.allParticipants = new ParticipantList();
        this.topThreeList = new ParticipantList();
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 4 (b)
     * Adds a participant to the list if they are not already present.
     * @param participant the participant to be added
     * @return true if the participant was added, false if a duplicate was found
     */
    public boolean inputParticipantInformation(Participant participant) {
        if (!this.allParticipants.contains(participant.getParticipantID())) {
            this.allParticipants.addToStart(participant);
            return true;
        }
        System.out.println("Duplicate record found");
        return false;
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Question: 4 (e)
     * Assignemnt 2
     * Inserts a participant at a specified index if they are not already present.
     * @param participant the participant to be inserted
     * @param index the index at which the participant should be inserted
     * @return true if the participant was inserted, false if a duplicate was found
     */
    public boolean insertParticipantAtIndex(Participant participant, int index) {
        if (!this.allParticipants.contains(participant.getParticipantID())) {
            this.allParticipants.insertAtIndex(participant, index);
            return true;
        }
        return false;
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Assignemnt 2
     * Question: 4 (e)
     * Inserts a participant at a specified index if they are not already present.
     * Removes a participant from the list at a specified index.
     * @param index the index of the participant to be removed
     */
    public void removeFromIndex(int index) {
        allParticipants.deleteFromIndex(index);
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Assignemnt 2
     * Question: 4 (e)
     * Inserts a participant at a specified index if they are not already present.
     * Replaces a participant at a specified index with a new participant.
     * @param participant the new participant
     * @param index the index at which the participant should be replaced
     * @return true if the participant was replaced, false if the index is invalid
     */
    public boolean replaceAtIndex(Participant participant, int index) {
        return allParticipants.replaceAtIndex(participant, index);
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Assignemnt 2
     * Question: 4 (c)
     * Inserts a participant at a specified index if they are not already present.
     * Orders the participants based on their decorative values and material costs,
     * and updates the top three participants list.
     */
    public void orderParticipants() {
        ArrayList<Participant> participants = allParticipants.getListOfParticipants();
        participants.sort(Comparator.comparing(Participant::getDecorativeValues).reversed()
                .thenComparing(Participant::getMaterialCost));
        topThreeList = new ParticipantList();
        for (int i = participants.size() - 1; i >= 0; i--) {
            if (i < 3) {
                topThreeList.addToStart(participants.get(i));
            }
        }
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Assignemnt 2
     * Question: 4 (c)
     * Prints information about the participants in the request information list.
     * @param requestInformationList the list of participants for which information is requested
     */
    public void printInformation(ArrayList<Participant> requestInformationList) {
        orderParticipants();
        for (Participant participant : requestInformationList) {
            if (topThreeList.contains(participant.getParticipantID())) {
                Participant first = getParticipantAtPositionFromTopThree(1);
                Participant second = getParticipantAtPositionFromTopThree(2);
                Participant third = getParticipantAtPositionFromTopThree(3);
                if (participant.equals(first)) {
                    if (second != null && second.getDecorativeValues() == participant.getDecorativeValues()) {
                        System.out.println(participant.getParticipantID() + " wins the Luminary Legend award with a collection having highest decorative value and a lower material cost");
                    } else {
                        System.out.println(participant.getParticipantID() + " wins the Luminary Legend award with a collection having highest decorative value");
                    }
                } else if (participant.equals(second)) {
                    if (third != null && third.getDecorativeValues() == participant.getDecorativeValues()) {
                        System.out.println(participant.getParticipantID() + " wins the Artisan's Heart award with a collection having second highest decorative value and a lower material cost");
                    } else {
                        System.out.println(participant.getParticipantID() + " wins the Artisan's Heart award with a collection having second highest decorative value");
                    }
                } else if (participant.equals(third)) {
                    if (second.getDecorativeValues() == participant.getDecorativeValues()) {
                        System.out.println(participant.getParticipantID() + " wins the Candlelight Dreamer award with a collection having third highest decorative value and a higher material cost");
                    } else {
                        System.out.println(participant.getParticipantID() + " wins the Candlelight Dreamer award with a collection having third highest decorative value");
                    }
                }
            } else {
                if (getParticipantAtPositionFromTopThree(3).getDecorativeValues() == participant.getDecorativeValues()) {
                    System.out.println(participant.getParticipantID() + " is not in top three owing to collection with higher material cost");
                } else {
                    System.out.println(participant.getParticipantID() + " is not in top three owing to collection with low decorative value");
                }
            }
        }
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Assignemnt 2
     * Question: 4 (f)
     * Retrieves a participant from the top three list based on their position.
     * @param position the position (1-based) of the participant in the top three list
     * @return the participant at the specified position, or null if the position is invalid
     */
    public Participant getParticipantAtPositionFromTopThree(int position) {
        return topThreeList.getParticipantAtIndex(position - 1);
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Retrieves the list of all participants.
     * @return the list of all participants
     */
    public ParticipantList getAllParticipants() {
        return allParticipants;
    }

    /**
     * Written by: Tanveer Reza 40292971
     * Assignemnt 2
     * Question: 4 (f)
     * Checks if a participant is in the top three list.
     * @param participant the participant to check
     * @return true if the participant is in the top three list, false otherwise
     */
    @Override
    public boolean isInTheTopThree(Participant participant) {
        return topThreeList.contains(participant.getParticipantID());
    }
}