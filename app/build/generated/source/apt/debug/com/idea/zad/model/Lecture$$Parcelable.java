
package com.idea.zad.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class Lecture$$Parcelable
    implements Parcelable, ParcelWrapper<com.idea.zad.model.Lecture>
{

    private com.idea.zad.model.Lecture lecture$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Lecture$$Parcelable>CREATOR = new Creator<Lecture$$Parcelable>() {


        @Override
        public Lecture$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Lecture$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Lecture$$Parcelable[] newArray(int size) {
            return new Lecture$$Parcelable[size] ;
        }

    }
    ;

    public Lecture$$Parcelable(com.idea.zad.model.Lecture lecture$$2) {
        lecture$$0 = lecture$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(lecture$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.idea.zad.model.Lecture lecture$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(lecture$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(lecture$$1));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.idea.zad.model.Lecture.class, lecture$$1, "details"));
            parcel$$1 .writeInt(InjectionUtil.getField(int.class, com.idea.zad.model.Lecture.class, lecture$$1, "id"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.idea.zad.model.Lecture.class, lecture$$1, "title"));
            parcel$$1 .writeInt(InjectionUtil.getField(int.class, com.idea.zad.model.Lecture.class, lecture$$1, "categoryId"));
            parcel$$1 .writeInt((InjectionUtil.getField(boolean.class, com.idea.zad.model.Lecture.class, lecture$$1, "isFavorite")? 1 : 0));
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.idea.zad.model.Lecture getParcel() {
        return lecture$$0;
    }

    public static com.idea.zad.model.Lecture read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.idea.zad.model.Lecture lecture$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            lecture$$4 = new com.idea.zad.model.Lecture();
            identityMap$$1 .put(reservation$$0, lecture$$4);
            InjectionUtil.setField(com.idea.zad.model.Lecture.class, lecture$$4, "details", parcel$$3 .readString());
            InjectionUtil.setField(com.idea.zad.model.Lecture.class, lecture$$4, "id", parcel$$3 .readInt());
            InjectionUtil.setField(com.idea.zad.model.Lecture.class, lecture$$4, "title", parcel$$3 .readString());
            InjectionUtil.setField(com.idea.zad.model.Lecture.class, lecture$$4, "categoryId", parcel$$3 .readInt());
            InjectionUtil.setField(com.idea.zad.model.Lecture.class, lecture$$4, "isFavorite", (parcel$$3 .readInt() == 1));
            com.idea.zad.model.Lecture lecture$$3 = lecture$$4;
            identityMap$$1 .put(identity$$1, lecture$$3);
            return lecture$$3;
        }
    }

}
