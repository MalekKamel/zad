
package com.idea.zad.model;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class LectureCategory$$Parcelable
    implements Parcelable, ParcelWrapper<com.idea.zad.model.LectureCategory>
{

    private com.idea.zad.model.LectureCategory lectureCategory$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<LectureCategory$$Parcelable>CREATOR = new Creator<LectureCategory$$Parcelable>() {


        @Override
        public LectureCategory$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new LectureCategory$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public LectureCategory$$Parcelable[] newArray(int size) {
            return new LectureCategory$$Parcelable[size] ;
        }

    }
    ;

    public LectureCategory$$Parcelable(com.idea.zad.model.LectureCategory lectureCategory$$2) {
        lectureCategory$$0 = lectureCategory$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(lectureCategory$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.idea.zad.model.LectureCategory lectureCategory$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(lectureCategory$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(lectureCategory$$1));
            parcel$$1 .writeInt(lectureCategory$$1 .id);
            parcel$$1 .writeString(lectureCategory$$1 .title);
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.idea.zad.model.LectureCategory getParcel() {
        return lectureCategory$$0;
    }

    public static com.idea.zad.model.LectureCategory read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.idea.zad.model.LectureCategory lectureCategory$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            lectureCategory$$4 = new com.idea.zad.model.LectureCategory();
            identityMap$$1 .put(reservation$$0, lectureCategory$$4);
            lectureCategory$$4 .id = parcel$$3 .readInt();
            lectureCategory$$4 .title = parcel$$3 .readString();
            com.idea.zad.model.LectureCategory lectureCategory$$3 = lectureCategory$$4;
            identityMap$$1 .put(identity$$1, lectureCategory$$3);
            return lectureCategory$$3;
        }
    }

}
