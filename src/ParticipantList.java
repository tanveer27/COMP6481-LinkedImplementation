import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Name and ID: Tanveer Reza
 * Assignment # 2
 * Question: 3
 * Due Date: 09/11/2024
 * The ParticipantList class represents a linked list of participants.
 * It provides methods to manipulate the list, such as adding, inserting, deleting, and finding participants.
 */
public class ParticipantList {

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(a)
     * The ParticipantNode class represents a node in the linked list.
     * Each node contains a participant and a reference to the next node.
     */
    private class ParticipantNode {
        private Participant participant;
        private ParticipantNode nextParticipantNode;

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(2)
         * Constructs an empty ParticipantNode.
         */
        public ParticipantNode() {
            this.participant = null;
            this.nextParticipantNode = null;
        }

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(3)
         * Constructs a ParticipantNode with the specified participant and next node.
         * @param participant the participant to be stored in the node
         * @param participantNode the next node in the list
         */
        public ParticipantNode(Participant participant, ParticipantNode participantNode) {
            this.participant = new Participant(participant, participant.getParticipantID());
            this.nextParticipantNode = participantNode;
        }

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(4)
         * Constructs a ParticipantNode by copying another node.
         * @param participantNode the node to be copied
         */
        public ParticipantNode(ParticipantNode participantNode) {
            this.participant = new Participant(participantNode.getParticipant(), participantNode.getParticipant().getParticipantID());
            this.nextParticipantNode = (participantNode.getNextParticipantNode() != null)
                    ? new ParticipantNode(participantNode.getNextParticipantNode())
                    : null;
        }

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(5)
         * Creates and returns a copy of this node.
         * @return a clone of this node
         */
        @Override
        public ParticipantNode clone() {
            return new ParticipantNode(this);
        }

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(6)
         * Gets the participant stored in this node.
         * @return the participant stored in this node
         */
        public Participant getParticipant() {
            return participant;
        }

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(6)
         * Sets the participant stored in this node.
         * @param participant the participant to be stored in this node
         */
        public void setParticipant(Participant participant) {
            this.participant = new Participant(participant, participant.getParticipantID());
        }

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(6)
         * Gets the next node in the list.
         * @return the next node in the list
         */
        public ParticipantNode getNextParticipantNode() {
            return nextParticipantNode;
        }

        /**
         *  Written by: Tanveer Reza 40292971
         *  Assignment 2
         *  Question: 3(a)(6)
         * Sets the next node in the list.
         * @param nextParticipantNode the next node in the list
         */
        public void setNextParticipantNode(ParticipantNode nextParticipantNode) {
            this.nextParticipantNode = nextParticipantNode;
        }
    }

    private ParticipantNode head;
    private int size;

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(d)
     * Constructs an empty ParticipantList.
     */
    public ParticipantList() {
        this.head = null;
        this.size = 0;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(e)
     * Constructs a ParticipantList by copying another list.
     * @param list the list to be copied
     */
    public ParticipantList(ParticipantList list) {
        if (list.head == null) {
            this.head = null;
        } else {
            this.head = list.head.clone();
        }
        this.size = list.size;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(f)
     * Adds a participant to the start of the list.
     * @param participant the participant to be added
     */
    public void addToStart(Participant participant) {
        head = new ParticipantNode(participant, head);
        size++;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(g)
     * Inserts a participant at the specified index in the list.
     * @param participant the participant to be inserted
     * @param index the index at which the participant should be inserted
     * @throws NoSuchElementException if the index is invalid
     */
    public void insertAtIndex(Participant participant, int index) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException("Invalid index " + index);
        }

        if (index == 0) {
            addToStart(participant);
        } else {
            ParticipantNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextParticipantNode();
            }

            current.setNextParticipantNode(new ParticipantNode(participant, current.getNextParticipantNode()));
            size++;
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(h)
     * Deletes the participant at the specified index from the list.
     * @param index the index of the participant to be deleted
     * @throws NoSuchElementException if the index is invalid
     */
    public void deleteFromIndex(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Invalid index." + index);
        }

        if (index == 0) {
            deleteFromStart();
        } else {
            ParticipantNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNextParticipantNode();
            }
            current.setNextParticipantNode(current.getNextParticipantNode().getNextParticipantNode());
            size--;
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(i)
     * Deletes the participant from the start of the list.
     * @throws NoSuchElementException if the list is empty
     */
    public void deleteFromStart() {
        if (head != null) {
            head = head.getNextParticipantNode();
            size--;
        } else {
            throw new NoSuchElementException("No participants to delete.");
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(j)
     * Replaces the participant at the specified index with a new participant.
     * @param participant the new participant
     * @param index the index at which the participant should be replaced
     * @return true if the participant was replaced, false if the index is invalid
     */
    public boolean replaceAtIndex(Participant participant, int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        ParticipantNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextParticipantNode();
        }

        current.setParticipant(participant);
        return true;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(k)
     * Finds a participant by their ID.
     * @param participantID the ID of the participant to be found
     * @param showIterations whether to show the number of iterations taken to find the participant
     * @return the participant if found, null otherwise
     */
    public Participant find(String participantID, boolean showIterations) {
        ParticipantNode current = head;
        int iterations = 0;
        while (current != null) {
            iterations++;
            if (current.getParticipant().getParticipantID().equals(participantID)) {
                if (showIterations)
                    System.out.println(participantID + " found in " + iterations + " iterations.");
                return new Participant(current.getParticipant(), current.getParticipant().getParticipantID());
            }
            current = current.getNextParticipantNode();
        }
        if (showIterations)
            System.out.println(participantID + " not found after " + iterations + " iterations.");
        return null;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(l)
     * Checks if the list contains a participant with the specified ID.
     * @param participantID the ID of the participant to be checked
     * @return true if the participant is found, false otherwise
     */
    public boolean contains(String participantID) {
        return find(participantID, false) != null;
    }


    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3(m)
     * Compares this list to another list for equality.
     * @param compareList the list to be compared
     * @return true if the lists are equal, false otherwise
     */
    public boolean equals(ParticipantList compareList) {
        if (this.size != compareList.size) {
            return false;
        }

        ParticipantNode current1 = this.head;
        ParticipantNode current2 = compareList.head;

        while (current1 != null && current2 != null) {
            if (!current1.getParticipant().equals(current2.getParticipant())) {
                return false;
            }
            current1 = current1.getNextParticipantNode();
            current2 = current2.getNextParticipantNode();
        }

        return true;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     * Gets a list of all participants in the list.
     * @return an ArrayList of all participants
     */
    public ArrayList<Participant> getListOfParticipants() {
        ArrayList<Participant> participants = new ArrayList<>();
        ParticipantNode current = head;
        while (current != null) {
            participants.add(new Participant(current.getParticipant(), current.getParticipant().getParticipantID()));
            current = current.getNextParticipantNode();
        }
        return participants;
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     * Gets the participant at the specified index in the list.
     * @param index the index of the participant to be retrieved
     * @return the participant at the specified index, or null if the index is invalid
     */
    public Participant getParticipantAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        ParticipantNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextParticipantNode();
        }

        return new Participant(current.getParticipant(), current.getParticipant().getParticipantID());
    }
}