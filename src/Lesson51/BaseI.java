package Lesson51;

import java.util.Collection;
import java.util.Iterator;

public interface BaseI<T,U> {
    public default Mashine calc(Collection<T> collection){
        U param;
        Mashine mashine = null;
        if (collection != null && !collection.isEmpty()) {
            Iterator<T> iterator = collection.iterator();
            T element = iterator.next();
            mashine = getMashine(element);
            param = getValue(element);
            while(iterator.hasNext()) {
                T current = iterator.next();
                U currentValue = getValue(current);
                if (isPower(currentValue, param)) {
                    param = currentValue;
                    mashine = getMashine(current);
                }
            }
        }
        return mashine;
    }

    public default Mashine middle(Collection<T> collection){
        int mid;
        Mashine mashine = null;
        if (collection != null && !collection.isEmpty()) {
            mid=collection.size()/2;
            Iterator<T> iterator = collection.iterator();
            for (int i=0;i<=mid-1;i++){
            T element = iterator.next();
            }
            T element = iterator.next();
            mashine = getMashine(element);
        }
        return mashine;
    }

    public default Integer avgMashine(Collection<T> collection){
        U param;
        Integer res=0;
        Mashine mashine = null;
        if (collection != null && !collection.isEmpty()) {
            Iterator<T> iterator = collection.iterator();
            T element = iterator.next();
            mashine = getMashine(element);
            param = getValue(element);
            while(iterator.hasNext()) {
                T current = iterator.next();
                U currentValue = getValue(current);
                res +=(Integer) currentValue;
            }
        }
        return res/collection.size();
    }

    Mashine getMashine(T element);

    U getValue(T element);

    boolean isPower(U u1, U u2);
}
