package net.justdave.nwsweatheralertswidget;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class NWSAlertList extends ArrayList<NWSAlertEntry> implements Parcelable {

    private static final long serialVersionUID = 1L;
    public static final Creator<NWSAlertList> CREATOR = new Creator<NWSAlertList>() {
        @Override
        public NWSAlertList[] newArray(int size) {
            return new NWSAlertList[size];
        }

        @Override
        public NWSAlertList createFromParcel(Parcel source) {
            return new NWSAlertList(source);
        }
    };

    public NWSAlertList() {
        super();
    }

    @SuppressWarnings("unchecked")
    private NWSAlertList(Parcel source) {
        this.clear();
        this.addAll(source.readArrayList(NWSAlertEntry.class.getClassLoader()));
    }

    @Override
    public String toString() {
        String result = "";
        Integer numAlerts = this.size();
        result = result.concat("There are currently ");
        result = result.concat(numAlerts.toString());
        result = result.concat(" active alerts");
        for (NWSAlertEntry entry : this) {
            result = result.concat("\n").concat(entry.toString());
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        //formatter:off
        if (this == o)                      { return true; }
        if (!(o instanceof NWSAlertList))   { return false; }
        NWSAlertList n = (NWSAlertList) o;
        if (size() != n.size())             { return false; }
        final int N = size();
        for (int i = 0; i < N; i++) {
            if (!(get(i).equals(n.get(i)))) { return false; }
        }
        //formatter:on
        return true;
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList((List<NWSAlertEntry>) this);
    }

}
