package com.example.myhealthplanner.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.myhealthplanner.database.converters.DateConverter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(tableName = "profile")
public class Profile {

    @ColumnInfo(name = "profile_id")
    @PrimaryKey(autoGenerate = true)
    private long profileId;

    @ColumnInfo(name = "profile_image", typeAffinity = ColumnInfo.BLOB)
    private byte[] profileImage;

}
