package Lesson51;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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


    /*public default int compare(T t1, T t2){
        U param1 = getValue(t1);;
        U param2 = getValue(t2);
            if (param1.equals(param2)) {return 0;}
            else if (isPower(param1, param2)) {
                  return 1;
                }
            else return -1;
        }*/


    public default Mashine middle(Collection<T> collection){
        int mid;
        Mashine mashine = null;
        if (collection != null && !collection.isEmpty()) {
            mid=collection.size()/2;
            Iterator<T> iterator = collection.iterator();
            for (int i=0;i<=mid-1;i++){
            iterator.next();
            }
            T element = iterator.next();
            mashine = getMashine(element);
        }
        return mashine;
    }

    public default Integer avgMashine(Collection<T> collection){
        Integer res=0;
        if (collection == null || collection.isEmpty()) {return 0;}
        else  {
            Iterator<T> iterator = collection.iterator();
            while(iterator.hasNext()) {
                T current = iterator.next();
                U currentValue = getValue(current);
                res =sumValue(currentValue,res);
            }
        }
        return res/collection.size();
    }

    Mashine getMashine(T element);

    U getValue(T element);

    int sumValue(U u1, int curr);

    boolean isPower(U u1, U u2);

    public ArrayList<T> sort(ArrayList<T> collection);
}
