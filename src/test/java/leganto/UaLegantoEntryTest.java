package leganto;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class UaLegantoEntryTest {



    private UaLegantoEntry entry;


    public UaLegantoEntryTest(){
        entry= new UaLegantoEntry();
    }


    @Test
    public void toStringShouldNotReturnEmptyString(){
        assertThat(entry.toString(),is(not(emptyString())));

    }



}
