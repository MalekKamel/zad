
package com.idea.zad.model;

import android.os.Parcelable;

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
public class Category$$Parcelable
    implements Parcelable, ParcelWrapper<LectureCategory>
{

    private LectureCategory category$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Category$$Parcelable>CREATOR = new Creator<Category$$Parcelable>() {


        @Override
        public Category$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Category$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Category$$Parcelable[] newArray(int size) {
            return new Category$$Parcelable[size] ;
        }

    }
    ;

    public Category$$Parcelable(LectureCategory category$$2) {
        category$$0 = category$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(category$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(LectureCategory category$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(category$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(category$$1));
            parcel$$1 .writeInt(InjectionUtil.getField(int.class, LectureCategory.class, category$$1, "id"));
            parcel$$1 .writeString(InjectionUtil.getField(String.class, LectureCategory.class, category$$1, "title"));
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public LectureCategory getParcel() {
        return category$$0;
    }

    public static LectureCategory read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            LectureCategory category$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            category$$4 = new LectureCategory();
            identityMap$$1 .put(reservation$$0, category$$4);
            InjectionUtil.setField(LectureCategory.class, category$$4, "id", parcel$$3 .readInt());
            InjectionUtil.setField(LectureCategory.class, category$$4, "title", parcel$$3 .readString());
            LectureCategory category$$3 = category$$4;
            identityMap$$1 .put(identity$$1, category$$3);
            return category$$3;
        }
    }

}
