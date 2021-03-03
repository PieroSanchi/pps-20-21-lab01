package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> circularList = new ArrayList<>();
    private int position = 0;

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (position == circularList.size()) {
            return Optional.ofNullable(circularList.get(0));
        } else {
            return Optional.ofNullable(circularList.get(position++));
        }
    }

    @Override
    public Optional<Integer> previous() {
        if (position == 0) {
            position = circularList.size()-1;
            return Optional.ofNullable(circularList.get(position));
        } else {
            return Optional.ofNullable(circularList.get(--position));
        }
    }

    @Override
    public void reset() {
        circularList.set(position, circularList.get(0));
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
