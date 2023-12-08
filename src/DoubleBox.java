public class DoubleBox<T> {
    private RandomBox<T> first;
    private RandomBox<T> second;

    public boolean put(int key, T value) { // метод, проверяющий наличие заполненности переменной
        if (size() == 0) { //если размер ячейки по первой переменной равен нулю, значит там пусто
            first = new RandomBox<>(key, value);//тогда нужно заполнить первую переменную значением (либо ключ, либо значение)
            return true;
        }
        if (size() == 1) { //если вторая еременная пустая
            second = new RandomBox<>(key, value); //заполнить и её
            return true; //тогда - порядок
        }
        return false; //иначе - непорядок
    }

    public T get(int key) {
        if (first != null && first.tryUnlock(key) != null) { /*проверка соответствие ключа
        + чтобы вызвать метод у объекта нужно значение этого объекта, иначе будет ошибка*/
            return first.getValue();
        }
        if (second != null && second.tryUnlock(key) != null) {
            return second.getValue();
        }
        return null;
    }

    public int size() {
        if (first == null && second == null) return 0; //если обе не проинициализированы
        if (first != null && second != null) return 2; //если обе проинициализированы
        if (first != null || second != null) return 1; //или первое, или второе проинициализировано

        return -1; //костыль (либо надо exception травить)
    }
}
