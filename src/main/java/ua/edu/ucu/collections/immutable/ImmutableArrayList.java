package ua.edu.ucu.collections.immutable;



class ImmutableArrayList implements ImmutableList {
    private final Object[] array;
    private ImmutableArrayList(int y){
        this.array = new Object[y];
    }
    ImmutableArrayList(Object[] j){
        this.array = j;
    }
    ImmutableArrayList() {
        this.array = new Object[1];

    }

    @Override
    public ImmutableList add(Object e) {
        if (this.array[0] == null) {
            return new ImmutableArrayList(new Object[] {e});
        }
        ImmutableArrayList newArray = new ImmutableArrayList(this.size() + 1);
        int k = 0;
        for(Object i: this.array) {
            newArray.array[k] = i;
            k++;
        }
        newArray.array[k] = e;
        return newArray;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        ImmutableArrayList newArray = new ImmutableArrayList(this.size() + 1);
        for (int i =0; i < index; i++) {
            newArray.array[i] = this.array[i];
        }
        newArray.array[index] = e;
        for (int k = index + 1; k< newArray.size(); k++) {
            newArray.array[k] = this.array[k-1];
        }
        return newArray;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList newArray = new ImmutableArrayList(this.size() + c.length);
        for (int i = 0; i < this.size(); i++){
            newArray.array[i] = this.array[i];
        }
        int indC = 0;
        for (int k = this.size(); k < newArray.size(); k++) {
            newArray.array[k] = c[indC];
            indC++;
        }
        return newArray;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        ImmutableArrayList newArray = new ImmutableArrayList(this.size() + c.length);
        for (int i = 0; i < index; i++) {
            newArray.array[i] = this.array[i];
        }
        int indC = 0;
        for (int ind = index; ind < index + c.length; ind++) {
            newArray.array[ind] = c[indC];
            indC++;
        }
        for (int indRest = index + c.length; indRest < this.size() + c.length; indRest++) {
            newArray.array[indRest] = this.array[index];
            index++;
        }
        return newArray;
    }

    @Override
    public Object get(int index) {
        return this.array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        ImmutableArrayList newArray = new ImmutableArrayList(this.size() - 1);
        for (int i = 0; i < index; i++) {
            newArray.array[i] = this.array[i];
        }
        for (int i = index + 1; i < this.size() ; i++) {
            newArray.array[i - 1] = this.array[i];
        }
        return newArray;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableArrayList newArray = new ImmutableArrayList(this.size());
        for (int i = 0; i < index; i++) {
            newArray.array[i] = this.array[i];
        }
        newArray.array[index] = e;
        for (int k = index + 1; k < newArray.size(); k++) {
            newArray.array[k] = this.array[k];
        }
        return newArray;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++){
            if (this.array[i] == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        int size = 0;
        for (Object ignored : this.array) {
            size++;
        }
        return size;
    }

    @Override
    public ImmutableList clear() {

        return new ImmutableArrayList(new Object[]{null});
    }

    @Override
    public boolean isEmpty() {
        for (Object i : this.array) {
            if (i != null) {
                return false;
            }
        }
        return true;
    }



    @Override
    public Object[] toArray() {
        Object[] finalArray = new Object[this.size()];
        for (int i = 0; i < this.size(); i ++) {
            finalArray[i] = this.array[i];
        }
        return finalArray;
    }

    @Override
    public String toString() {
        String  res = "";
        for(Object i : this.array) {
            res += i + ", " ;
        }
        return res.substring(0,res.length() - 2);
    }
}
