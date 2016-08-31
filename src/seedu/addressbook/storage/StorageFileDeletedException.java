package seedu.addressbook.storage;

/**
 * Signals data cannot be saved to the storage file that has been deleted.
 */
public class StorageFileDeletedException extends Exception {

    /**
     * @param message should inform user about the deleted storage file and to create one
     */
    public StorageFileDeletedException(String message) {
        super(message);
    }
}
