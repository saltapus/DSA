// UnitTestVertex.java
import java.io.*;
import io.*;

// Test harness for the Vertex class from DSA practicals 00 and 01.
//
// This works with the Vertex class only under certain assumptions - if you made different assumptions
// then you'll need to adjust this harness. It's mainly here to give you an idea of the sort of things
// I'm looking for in a test harness.

public class UnitTestVertex
{	
   public static void main(String args[])
   {
      int iNumPassed = 0;
      int iNumTests = 0;
      Vertex vertex;
      char cVertexDeviceType;
      String sVertexName;
      float fVertexReliability;
      int iVertexCost;
      
      // Test with normal conditions (shouldn't throw exceptions)
      System.out.println("\n");
      System.out.println("Testing Normal Conditions - Constructor");
      System.out.println("=======================================");
      try
      {   
         iNumTests++;
         System.out.print("Testing creation of Vertex: ");

         cVertexDeviceType = Vertex.DEVICETYPE_RV325;	// Theoretically we should test each possible device type, just to be sure
         sVertexName = new String("Test device");
         fVertexReliability = (float)0.9;
         iVertexCost = 150;
         vertex = new Vertex(cVertexDeviceType, sVertexName, fVertexReliability, iVertexCost );
         iNumPassed++;
         System.out.println("passed");

         iNumTests++;
         System.out.print("Testing display of Vertex: ");
	 System.out.println( vertex.display() );
         iNumPassed++;
         System.out.println("passed");

         iNumTests++;
         System.out.print("Testing inDeviceType: ");
         cVertexDeviceType = vertex.getDeviceType();
         if (cVertexDeviceType != Vertex.DEVICETYPE_RV325 )
         {
           throw new IllegalArgumentException("FAILED");
         }
         else
         {
            iNumPassed++;
            System.out.println("passed");
         }

         iNumTests++;
         System.out.print("Testing inName: ");
         sVertexName = vertex.getName();
         if ( !sVertexName.equals("Test device") )
         {
           throw new IllegalArgumentException("FAILED");
         }
         else
         {
            iNumPassed++;
            System.out.println("passed");
         }

         iNumTests++;
         System.out.print("Testing inRel: ");
         fVertexReliability = vertex.getReliability();
         if ( Math.abs( fVertexReliability - (float)0.9 ) > 0.00001) // Adjust for desired accuracy
         {
           throw new IllegalArgumentException("FAILED");
         }
         else
         {
            iNumPassed++;
            System.out.println("passed");
         }

         iNumTests++;
         System.out.print("Testing inCost: ");
         iVertexCost = vertex.getCost();
         if (iVertexCost != 150 )
         {
           throw new IllegalArgumentException("FAILED");
         }
         else
         {
            iNumPassed++;
            System.out.println("passed");
         }

      }
      catch(IllegalArgumentException e)
      {
         System.out.println("Illegal Argument:" + e.getMessage());
      }
      catch(Exception e)
      {
         System.out.println("FAILED");
      }

   // Tests with error conditions (SHOULD throw exceptions)
   // Testing constructor's parameters of ore type and units.
   System.out.println("\n");
   System.out.println("Testing Error Conditions - Constructor");
   System.out.println("======================================");

   // Testing Constructor - we don't have much else to test
   // This test would also be redundant if they choose to use enums instead of constants.
   cVertexDeviceType = Vertex.DEVICETYPE_RV325;
   sVertexName = new String("Test device");
   fVertexReliability = (float)0.9;
   iVertexCost = 150;
   try
   {
         iNumTests++;
         cVertexDeviceType = 'X';	// Testing a random character that we haven't used
         System.out.print("Testing bad type: ");
         vertex = new Vertex(cVertexDeviceType, sVertexName, fVertexReliability, iVertexCost );
         System.out.println("FAILED");
   }
   catch(Exception e) { iNumPassed++; System.out.println("passed"); }
   cVertexDeviceType = Vertex.DEVICETYPE_RV325;

   try
   {
         iNumTests++;
         System.out.print("Testing null name: ");
         sVertexName = null;		// All types other than this are legal. We are relying on garbage collection here
         vertex = new Vertex(cVertexDeviceType, sVertexName, fVertexReliability, iVertexCost );
         System.out.println("FAILED");
   }
   catch(Exception e) { iNumPassed++; System.out.println("passed"); }
   sVertexName = new String("Test device");

   // For reliability, we need to check two bounds
   try
   {
         iNumTests++;
         System.out.print("Testing high reliability: ");
         fVertexReliability = (float)1.2;	// Too high
         vertex = new Vertex(cVertexDeviceType, sVertexName, fVertexReliability, iVertexCost );
         System.out.println("FAILED");
   }
   catch(Exception e) { iNumPassed++; System.out.println("passed"); }
   try
   {
         iNumTests++;
         System.out.print("Testing negative reliability: ");
         fVertexReliability = (float)-0.1;	// Too low 
         vertex = new Vertex(cVertexDeviceType, sVertexName, fVertexReliability, iVertexCost );
         System.out.println("FAILED");
   }
   catch(Exception e) { iNumPassed++; System.out.println("passed"); }
   fVertexReliability = (float)0.9;

   try
   {
         iNumTests++;
         System.out.print("Testing negative cost: ");
         iVertexCost = -1;			// Negatives aren't allowed
         vertex = new Vertex(cVertexDeviceType, sVertexName, fVertexReliability, iVertexCost );
         System.out.println("FAILED");
   }
   catch(Exception e) { iNumPassed++; System.out.println("passed"); }
   try
   {
         iNumTests++;
         System.out.print("Testing zero cost: ");
         iVertexCost = 0;			// Also testing zero, just in case
         vertex = new Vertex(cVertexDeviceType, sVertexName, fVertexReliability, iVertexCost );
         System.out.println("FAILED");
   }
   catch(Exception e) { iNumPassed++; System.out.println("passed"); }
   iVertexCost = 150;

  } // End of main
} // End of Class


