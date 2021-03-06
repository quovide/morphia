package com.google.code.morphia.utils;


import org.junit.Test;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.TestBase;

import static org.junit.Assert.assertEquals;


/**
 * @author ScottHernandez
 */
public class LongIdEntityTest extends TestBase {
  static class MyEntity extends LongIdEntity {
    protected MyEntity() {
      super(null);
    }

    public MyEntity(final Datastore ds) {
      super(ds);
    }
  }

  @Test
  public void testMonoIncreasingId() throws Exception {
    MyEntity ent = new MyEntity(ds);
    ds.save(ent);
    assertEquals(1L, ent.myLongId, 0);
    ent = new MyEntity(ds);
    ds.save(ent);
    assertEquals(2L, ent.myLongId, 0);
  }

}
