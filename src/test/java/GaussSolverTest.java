import com.jatrix.core.Matrix;
import com.jatrix.core.StrassenProduct;
import com.jatrix.exceptions.MatrixSizeException;
import com.jatrix.exceptions.SolverNotSupportedException;
import com.jatrix.solvers.CramerSolver;
import com.jatrix.solvers.GaussSolver;
import org.junit.Assert;
import org.junit.Test;

public class GaussSolverTest {
    @Test(expected = SolverNotSupportedException.class)
    public void constructorTest_takeNonSquareMatrixToConstructor_assertMustThrownSolverNotSupportedException() {
        // Arrange
        Matrix xCoefficients = new Matrix(new double[][]{{2, 2}, {5, -8}, {9, 3}});
        double[] constants = {3, 4, 5};

        // Act
        GaussSolver gaussSolver = new GaussSolver(xCoefficients, constants);
        double[] actualRoots = gaussSolver.getRoots();
    }

    @Test(expected = MatrixSizeException.class)
    public void constructorTest_takeNotEqualedMatrixCoefficientsAndConstantsArray_assertMustThrownMatrixSizeException() {
        // Arrange
        Matrix xCoefficients = new Matrix(new double[][]{{2, 2, 8}, {5, -8, 9}, {1, 9, 3}});
        double[] constants = {3, 4};

        // Act
        GaussSolver gaussSolver = new GaussSolver(xCoefficients, constants);
        double[] actualRoots = gaussSolver.getRoots();
    }

    @Test
    public void getRootsTest_getRootsOfSystemOfLinearEquations_assertEquals() {
        // Arrange
        Matrix xCoefficients = new Matrix(new double[][]{{2, 2, -1}, {-4, 1, 1}, {4, -3, 2}});
        double[] constants = {3, 4, 5};
        double[] expectedRoots = {1, 3, 5};

        // Act
        GaussSolver gaussSolver = new GaussSolver(xCoefficients, constants);
        double[] actualRoots = gaussSolver.getRoots();

        // Assert
        Assert.assertArrayEquals(expectedRoots, actualRoots, 1E-8);
    }
}
