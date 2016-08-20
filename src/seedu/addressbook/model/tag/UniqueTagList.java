package seedu.addressbook.model.tag;

import seedu.addressbook.common.Utils;
import seedu.addressbook.model.exception.DuplicateDataException;

import java.util.*;

/**
 * A list of tags. Does not allow nulls or duplicates.
 *
 * @see Tag#equals(Object)
 * @see Utils#elementsAreUnique(Collection)
 */
public class UniqueTagList implements Iterable<Tag> {

    /**
     * Signals that an operation would have violated the 'no duplicates' property of the list.
     */
    public static class DuplicateTagException extends DuplicateDataException {
        protected DuplicateTagException() {
            super("Operation would result in duplicate tags");
        }
    }

    /**
     * Signals that an operation targeting a specified Tag in the list would fail because
     * there is no such matching Tag in the list.
     */
    public static class TagNotFoundException extends Exception {}

    private final List<Tag> internalList = new ArrayList<>();

    /**
     * Constructs an empty TagList.
     */
    public UniqueTagList() {}

    /**
     * Constructs a tag list with the given tags.
     */
    public UniqueTagList(Tag... tags) throws DuplicateTagException {
        final List<Tag> initialTags = Arrays.asList(tags);
        if (!Utils.elementsAreUnique(initialTags)) {
            throw new DuplicateTagException();
        }
        internalList.addAll(initialTags);
    }

    /**
     * Constructs a tag list with the given tags.
     */
    public UniqueTagList(Collection<Tag> tags) throws DuplicateTagException {
        if (!Utils.elementsAreUnique(tags)) {
            throw new DuplicateTagException();
        }
        internalList.addAll(tags);
    }

    /**
     * Constructs a tag list with the given tags.
     */
    public UniqueTagList(Set<Tag> tags) {
        internalList.addAll(tags);
    }

    /**
     * Constructs a shallow copy of the given tag list.
     */
    public UniqueTagList(UniqueTagList source) {
        internalList.addAll(source.internalList);
    }

    /**
     * All tags in this list as a Set. This set is mutable and change-insulated against the internal list.
     */
    public Set<Tag> toSet() {
        return new HashSet<>(internalList);
    }

    /**
     * Checks if the list contains an equivalent Tag as the given argument.
     */
    public boolean contains(Tag toCheck) {
        return internalList.contains(toCheck);
    }

    /**
     * Adds a Tag to the list.
     *
     * @throws DuplicateTagException if the Tag to add is a duplicate of an existing Tag in the list.
     */
    public void add(Tag toAdd) throws DuplicateTagException {
        if (contains(toAdd)) {
            throw new DuplicateTagException();
        }
        internalList.add(toAdd);
    }

    /**
     * Removes the equivalent Tag from the list.
     *
     * @throws TagNotFoundException if no such Tag could be found in the list.
     */
    public void remove(Tag toRemove) throws TagNotFoundException {
        final boolean TagFoundAndDeleted = internalList.remove(toRemove);
        if (!TagFoundAndDeleted) {
            throw new TagNotFoundException();
        }
    }

    /**
     * Clears all tags in list.
     */
    public void clear() {
        internalList.clear();
    }

    @Override
    public Iterator<Tag> iterator() {
        return internalList.iterator();
    }

}
