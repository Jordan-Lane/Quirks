package cmput301f17t12.quirks;

import org.junit.Test;

import cmput301f17t12.quirks.Enumerations.DropType;
import cmput301f17t12.quirks.Models.Drop;

import static org.junit.Assert.*;

public class DropsTest {

    @Test
    public void testGetDropType(){
        Drop drop = new Drop(DropType.larrybird);
        DropType dropType = drop.getDropType();
        assertEquals(dropType, DropType.larrybird);
    }

}

