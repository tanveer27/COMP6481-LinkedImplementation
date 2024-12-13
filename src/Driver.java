import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Name and ID: Tanveer Reza
 * Assignment # 2
 * Due Date: 09/11/2024
 * The Driver class is the entry point for the Diwali Competition Results System.
 * It provides a menu-driven interface for managing participants and their information.
 */
public class Driver {
    public static CompetitionResults competitionResults = new CompetitionResults();

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * The main method initializes the competition data and starts the main menu.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        populateCompetitionData();
        Scanner scanner = new Scanner(System.in);
        try {
            showMainMenu(scanner);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            exit(0);
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Populates the competition data with a predefined set of participants.
     */
    private static void populateCompetitionData() {
        Participant[] participants = new Participant[]{
                new Participant("MM", "MM", new int[]{12, 8, 5, 10, 6}),
                new Participant("GG", "GG", new int[]{7, 15, 3, 12, 9}),
                new Participant("RR", "RR", new int[]{10, 10, 10, 0, 2}),
                new Participant("TT", "TT", new int[]{5, 5, 15, 8, 7}),
                new Participant("DD", "DD", new int[]{9, 12, 4, 6, 1}),
                new Participant("SS", "SS", new int[]{4, 3, 20, 7, 10}),
                new Participant("LL", "LL", new int[]{8, 10, 6, 14, 5}),
                new Participant("BB", "BB", new int[]{3, 2, 18, 11, 4}),
                new Participant("EE", "EE", new int[]{11, 6, 7, 9, 8}),
                new Participant("CC", "CC", new int[]{15, 5, 5, 4, 2})
        };
        for (Participant participant : participants) {
            competitionResults.inputParticipantInformation(participant);
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Displays the main menu and handles user input.
     * @param scanner the Scanner object for reading user input
     */
    public static void showMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("Welcome to the Diwali Competition Results System created by Tanveer Reza");
            System.out.println("What do you want to do?");
            System.out.println("\t 1. Add Participants");
            System.out.println("\t 2. Add Request Information");
            System.out.println("\t 3. Find Participant By Id");
            System.out.println("\t 4. Remove participant from index");
            System.out.println("\t 5. Insert participant at index");
            System.out.println("\t 6. Replace participant at index");
            System.out.println("\t 7. Clone and print participant the participant with ID");
            System.out.println("\t 8. Check copy constructor for participant List");
            System.out.println("\t 9. Quit");
            System.out.print("Please enter your choice > ");

            int choice = Integer.parseInt(scanner.nextLine()); // assuming the user will only enter a number between 0-9

            switch (choice) {
                case 1:
                    addParticipantMenu(scanner);
                    break;
                case 2:
                    addRequestInformationMenu(scanner);
                    break;
                case 3:
                    findParticipantByIdMenu(scanner);
                    break;
                case 4:
                    removeParticipantFromIndex(scanner);
                    break;
                case 5:
                    insertParticipantAtIndex(scanner);
                    break;
                case 6:
                    replaceParticipantAtIndex(scanner);
                    break;
                case 7:
                    cloneAndPrintParticipant(scanner);
                    break;
                case 8:
                    verifyParticipantListCopyConstructor();
                    break;
                case 9:
                    System.out.println("Closing the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5."); // display clear error message when wrong choice entered
            }
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Handles the menu for adding participants.
     * @param scanner the Scanner object for reading user input
     */
    public static void addParticipantMenu(Scanner scanner) {
        while (true) {
            System.out.print("Please enter information for new participant or press only enter to exit: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            Participant newParticipant = getParticipantFromInput(input);
            if (competitionResults.inputParticipantInformation(newParticipant)) {
                System.out.println("Participant Added");
            } else {
                System.out.println("Duplicate Participant Found");
            }
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Handles the menu for adding request information.
     * @param scanner the Scanner object for reading user input
     */
    public static void addRequestInformationMenu(Scanner scanner) {
        ArrayList<Participant> requestInformation = new ArrayList<>();
        while (true) {
            System.out.print("Please enter participant id or press only enter to exit: ");
            String participantId = scanner.nextLine();
            if (participantId.isEmpty()) {
                competitionResults.printInformation(requestInformation);
                break;
            }
            if (competitionResults.getAllParticipants().contains(participantId)) {
                requestInformation.add(competitionResults.getAllParticipants().find(participantId, false));
                System.out.println("Request Information Added");
            } else {
                System.out.println("Invalid Participant Id.");
            }
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Handles the menu for finding a participant by ID.
     * @param scanner the Scanner object for reading user input
     */
    public static void findParticipantByIdMenu(Scanner scanner) {
        ArrayList<String> participantIds = new ArrayList<>();
        while (true) {
            System.out.print("Please enter participant id or press only enter to exit : ");
            String participantId = scanner.nextLine();
            if (participantId.isEmpty()) {
                for (String participant : participantIds) {
                    competitionResults.getAllParticipants().find(participant, true);
                }
                break;
            }
            participantIds.add(participantId);
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Handles the menu for removing a participant from a specified index.
     * @param scanner the Scanner object for reading user input
     */
    public static void removeParticipantFromIndex(Scanner scanner) {
        System.out.print("Please enter index number: ");
        int index = Integer.parseInt(scanner.nextLine());
        competitionResults.removeFromIndex(index);
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Handles the menu for replacing a participant at a specified index.
     * @param scanner the Scanner object for reading user input
     */
    public static void replaceParticipantAtIndex(Scanner scanner) {
        System.out.print("Please enter index number: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("Please enter information for new participant: ");
        String input = scanner.nextLine();
        Participant newParticipant = getParticipantFromInput(input);
        if (competitionResults.replaceAtIndex(newParticipant, index)) {
            System.out.println("Participant Replaced at index " + index);
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Handles the menu for inserting a participant at a specified index.
     * @param scanner the Scanner object for reading user input
     */
    public static void insertParticipantAtIndex(Scanner scanner) {
        System.out.print("Please enter index number: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.print("Please enter information for new participant: ");
        String input = scanner.nextLine();
        Participant newParticipant = getParticipantFromInput(input);
        if (competitionResults.insertParticipantAtIndex(newParticipant, index)) {
            System.out.println("Participant Added");
        } else {
            System.out.println("Duplicate Participant Found");
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Parses participant information from a string input.
     * @param input the string input containing participant information
     * @return a new Participant object
     */
    private static Participant getParticipantFromInput(String input) {
        String[] participantInformationArray = input.split(" ");
        return new Participant(participantInformationArray[0], participantInformationArray[0],
                new int[]{Integer.parseInt(participantInformationArray[1]),
                        Integer.parseInt(participantInformationArray[2]),
                        Integer.parseInt(participantInformationArray[3]),
                        Integer.parseInt(participantInformationArray[4]),
                        Integer.parseInt(participantInformationArray[5]),
                });
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 2
     * Handles the menu for cloning and printing a participant with a new ID.
     * @param scanner the Scanner object for reading user input
     */
    private static void cloneAndPrintParticipant(Scanner scanner) {
        System.out.print("Please enter participant Id to clone: ");
        String participantId = scanner.nextLine();
        Participant participant = competitionResults.getAllParticipants().find(participantId, false);
        if (participant != null) {
            Participant clonedParticipant = participant.clone();
            System.out.println(clonedParticipant);
        } else {
            System.out.println("Participant not found");
        }
    }

    /**
     *  Written by: Tanveer Reza 40292971
     *  Assignment 2
     *  Question: 3
     * Verifies the copy constructor of the ParticipantList class.
     */
    private static void verifyParticipantListCopyConstructor() {
        ParticipantList participantList = competitionResults.getAllParticipants();
        ParticipantList clonedParticipantList = new ParticipantList(participantList);
        if (participantList.equals(clonedParticipantList)) {
            System.out.println("Copy constructor works");
        } else {
            System.out.println("Copy constructor does not work");
        }
    }
}