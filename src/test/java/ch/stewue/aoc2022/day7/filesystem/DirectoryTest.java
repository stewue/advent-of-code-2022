package ch.stewue.aoc2022.day7.filesystem;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class DirectoryTest extends AbstractFilesystem {

    @Test
    public void testGetAllDirectoriesRecursive() {
        assertThat(ROOT.getAllDirectoriesRecursive()).containsExactly(ROOT, D1, D11, D3, D4);
    }

    @Test(dataProvider = "totalSize")
    public void testTotalSize(Directory directory, int totalSize) {
        assertThat(directory.totalSize()).isEqualTo(totalSize);
    }

    @DataProvider
    public Object[][] totalSize() {
        return new Object[][]{
                new Object[]{ROOT, 151},
                new Object[]{D1, 66},
                new Object[]{D11, 37},
                new Object[]{D3, 53},
                new Object[]{D4, 0}
        };
    }
}