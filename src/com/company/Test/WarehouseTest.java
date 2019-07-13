package com.company.Test;

import com.company.Warehouse.Exceptions.InvalidLimitException;
import com.company.Warehouse.Exceptions.WareHouseFullException;
import com.company.Warehouse.Gadget;
import com.company.Warehouse.Warehouse;
import com.company.Warehouse.Widget;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.Assert.*;

public class WarehouseTest {
    Warehouse warehouse = null;

    @Before
    public void setUp() {
        warehouse = new Warehouse(10);
    }

    @Test(expected = InvalidLimitException.class)
    public void negativeWarehouseLimit() {
        new Warehouse(-1);
    }

    @Test
    public void positiveWarehouseLimit() {
        assertNotNull(new Warehouse(10));
    }

    @Test
    public void insertGadget() {
        boolean res = warehouse.add(new Gadget("TV", 2f, 3));
        assertTrue(res);
    }

    @Test
    public void insertWidget() {
        boolean res = warehouse.add(new Widget("TV", 2f, LocalDate.parse("11-7-2019", DateTimeFormatter.ofPattern("dd-M-yyyy"))));
        assertTrue(res);
    }

    @Test(expected = WareHouseFullException.class)
    public void insertIntoFullWareHouse() throws ParseException {
        Warehouse tmp = new Warehouse(1);
        tmp.add(new Gadget("TV", 2f, 3));
        tmp.add(new Widget("TV", 2f, LocalDate.parse("11-12-2019", DateTimeFormatter.ofPattern("d-M-yyyy"))));
    }

    @Test
    public void getTotalValueTest() {
        warehouse.add(new Widget("TV", 2f, LocalDate.now()));
        warehouse.add(new Gadget("TV", 2f, 3));
        assertEquals(8f, warehouse.getTotalValue(), 0f);
    }

    @After
    public void tearDown() {
        warehouse = null;
    }
}
