package com.example.hw04_gymlog_v300;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

import com.example.hw04_gymlog_v300.database.GymLogDAO;
import com.example.hw04_gymlog_v300.database.GymLogDatabase;
import com.example.hw04_gymlog_v300.database.entities.GymLog;

@RunWith(AndroidJUnit4.class)
public class GymLogDatabaseTest {
    private GymLogDAO gymLogDAO;
    private GymLogDatabase db;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();

        db = Room.inMemoryDatabaseBuilder(context, GymLogDatabase.class)
                .allowMainThreadQueries()
                .build();

        gymLogDAO = db.gymLogDAO();
    }

    @After
    public void closeDb() {
        db.close();
    }

    @Test
    public void insertAndReadLog() {
        GymLog log = new GymLog("Squat", 200, 8, 1);
        gymLogDAO.insert(log);

        List<GymLog> logs = gymLogDAO.getAllRecords();

        assertFalse(logs.isEmpty());
        assertEquals("Squat", logs.get(0).getExercise());
    }
}
