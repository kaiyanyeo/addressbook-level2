package seedu.addressbook.storage;

/**
 * Signals data cannot be saved to the storage file that has been deleted.
 */
public class StorageFileDeletedException extends Exception {

    /**
     * @param message should inform user about the deleted storage file
     */
    public StorageFileDeletedException(String message) {
        super(message);
    }
}
