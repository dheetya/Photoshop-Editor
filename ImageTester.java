/**
*ImageEditor Project starter file
*This file is intended to be used for investigation
*Please make a new file for your ImageEditor Project
*/
//  https://docs.oracle.com/javase/7/docs/api/java/awt/Image.html

   import javax.imageio.*;
   import java.awt.*;
   import java.awt.image.*;
   import java.io.*;
   import java.lang.Math.*;
   import java.util.*;
	
   public class ImageTester
   {
        /**
        *  A method that turns the image red
        *  @param image and newTitle 
        */
       public static void makeRed(BufferedImage image, String newTitle) throws IOException
       {
  
           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

           for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int red = 0x00ff0000;
                    int og = image.getRGB(c,r);

                    red = red & og;


                    newImage.setRGB(c,r, red);
                }
            }
            

            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that turn the image blue
        *  @param image and newTitle  
        */
       public static void makeBlue(BufferedImage image, String newTitle) throws IOException
       {
   
           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

 
           for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int blue = 0x000000ff;
                    int og = image.getRGB(c,r);

                    blue = blue & og;

                    newImage.setRGB(c,r, blue);
                }
            }

            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that turns image green
        *  @param image and newTitle 
        */
       public static void makeGreen(BufferedImage image, String newTitle) throws IOException
       {

           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            
           for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int green = 0x0000ff00;
                    int og = image.getRGB(c,r);

                    green = green & og;

                    newImage.setRGB(c,r, green);
                }
            }
            

            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that inverts the image
        * @param image and newTitle 
        */
       public static void Invert(BufferedImage image, String newTitle) throws IOException
       {
   
           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);


           for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int og = image.getRGB(c,r);

                    newImage.setRGB(c,r, ~og); //tilda = invert
                }
            }

            
            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that removes the red pixels
        *  @param image and newTitle 
        */
       public static void deleteRed(BufferedImage image, String newTitle) throws IOException
       {
           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);


           for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int red = 0x0000ffff;
                    int og = image.getRGB(c,r);

                    red = red & og;


                    newImage.setRGB(c,r, red);
                }
            }
            
           
            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that takes away green pixels
        *  @param image and newTitle 
        */
       public static void deleteGreen(BufferedImage image, String newTitle) throws IOException
       {

           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);


           for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int green = 0x00ff00ff;
                    int og = image.getRGB(c,r);

                    green = green & og;

                    newImage.setRGB(c,r, green);
                }
            }
            
            // writes a new file with the new pixel details with the given parameter of the newTitle
            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that makes takes away blue pixels
        *  @param image and newTitle 
        */
       public static void deleteBlue(BufferedImage image, String newTitle) throws IOException
       {
 
           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {

                    int blue = 0x00ffff00;
                    int og = image.getRGB(c,r);

                    blue = blue & og;


                    newImage.setRGB(c,r, blue);
                }
            }
            
            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that makes the image gray
        *  @param image, newTitle 
        */
       public static void makeGray(BufferedImage image, String newTitle) throws IOException
       {
           // makes a new image of same size
           BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            // finds average of the color value and replaces the pixels
           for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int og = image.getRGB(c,r);

                    int redPix = og & 0x00ff0000;
                    redPix = redPix >> 16;

                    int greenPix = og & 0x0000ff00;
                    greenPix = greenPix >> 8;

                    int bluePix = og & 0x000000ff;

                    int avg = (redPix + greenPix + bluePix) / 3;

                    redPix = avg;
                    redPix = redPix << 8;
                    

                    greenPix = avg;
                    greenPix = greenPix << 16;

                    bluePix = avg;
                    

                    int newPix = 0x00ffffff;
                    newPix = redPix + greenPix + bluePix;


                    newImage.setRGB(c,r, newPix);
                }
            }
            
            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));
       }

        /**
        *  A method that creates four images but alters each one creating an andy warhol style image
        *  @param image and newTitle
        */
        public static void makeWarhol(BufferedImage image, String newTitle) throws IOException
        {
            // makes a new image of two times the original image's height and width
            int height = ( (image.getHeight()) * 2);
            int width = ( (image.getWidth()) * 2);
            BufferedImage warhol = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            
            // four for loops iterate through the OG image and then change the pictures
            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int og = image.getRGB(c,r);

                    warhol.setRGB(c,r, og);
                }
            }
            
            //tells where to start putting pixels
            int newHeight = image.getHeight();

            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int col = 0x00f00f00;
                    int og = image.getRGB(c,r);

                    col = col & og;

                    warhol.setRGB( c, newHeight, col);

                }
                newHeight++;
            }
            
            //reset after each for loop 
            int newWidth = image.getWidth();
            
            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {   
                    
                    int col = 0x0f0000ff;
                    int og = image.getRGB(c,r);

                    col = col & og;

                    warhol.setRGB( newWidth, r, col);
                    newWidth++;
                }
                newWidth = image.getWidth();
            }
            
            
            newHeight = image.getHeight();
            newWidth = image.getWidth();

            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int col = 0x0f000ff;
                    int og = image.getRGB(c,r);

                    col = col & og;

                    warhol.setRGB( newWidth, newHeight, col);
                    newWidth++;

                }
                newHeight++;
                newWidth = image.getWidth();
            }
            
            ImageIO.write(warhol, "jpg",new File(newTitle + ".jpg"));

        }

        /**
        *  A method that mirrors the image's left and right sides with the original image in the middle
        *  @param image and newTitle 
        */
        public static void makeMirrored(BufferedImage image, String newTitle) throws IOException
        {
            // makes a new image 
            int ogHeight = image.getHeight();
            int ogWidth = ( (image.getWidth()) * 3);

            int secWidthFirst = image.getWidth();
            int thirdWidthFirst = image.getWidth() * 2;

            BufferedImage mirrored = new BufferedImage(ogWidth, ogHeight, BufferedImage.TYPE_INT_RGB);
            
            
            // goes through left half from left to right
            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c <= image.getWidth() / 2; c++)
                {
                    int og = image.getRGB(c,r);

                    mirrored.setRGB(c,r, og);
                    mirrored.setRGB( ( image.getWidth() - c),r, og);
                }
            }

           
            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int og = image.getRGB(c,r);

                    mirrored.setRGB(secWidthFirst,r, og);
                    secWidthFirst++;
                }

                secWidthFirst = image.getWidth();
            }
            
            // iterates through the original image and places same pixels on right and left sides
            int count = 0;
            int totalWidth = mirrored.getWidth() - 1;

            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = image.getWidth() - 1; c >= image.getWidth() / 2; c--)
                {
                    
                    int og = image.getRGB(c,r);

                    mirrored.setRGB( (totalWidth - (image.getWidth() - c) ),r, og);
                    mirrored.setRGB( thirdWidthFirst,r, og);

                    thirdWidthFirst++;
                    count++;
                }

                count = 0;
                thirdWidthFirst = image.getWidth() * 2;
            }
            
            
            ImageIO.write(mirrored, "jpg",new File(newTitle + ".jpg"));

        }

        /**
        *  A method that rotates the original image clockwise
        *  @param image and newTitle
        */
        public static void rotateClockWise(BufferedImage image, String newTitle) throws IOException
        {
            // new image w opposite dimensions
            BufferedImage clockwise = new BufferedImage(image.getHeight(), image.getWidth(), BufferedImage.TYPE_INT_RGB); //they all have to be named newImage to be stores properly for some reason. I tried changing the names but got errors. 
            
            // switches rows and columns 
            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++)
                {
                    int og = image.getRGB(c,r);

                    clockwise.setRGB( image.getHeight() - r - 1, c, og);

                }
            }
    
            ImageIO.write(clockwise, "jpg",new File(newTitle + ".jpg"));

        }

        /*
        *@param image and newTitle
        * the purpose of this method is to create line art of the original image by finding each edge and shifting the pixels. 
        */

        public static void findEdges(BufferedImage image, String newTitle) throws IOException //best lineart ever for real
        {
            //same size as the og image
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int r = 0; r < image.getHeight(); r++)
            {
                for (int c = 0; c < image.getWidth(); c++) 
                {
                    if (c < image.getWidth() - 1)
                    {   
                        int thisPix = image.getRGB(c, r);
                        int rightPix = image.getRGB(c + 1, r);

                        int redDiff = ( (rightPix >> 16) - (thisPix >> 16) ) * ( (rightPix >> 16) - (thisPix >> 16) );
                        //System.out.print(redDiff);

                        int greenDiff = ( (rightPix >> 8) - (thisPix >> 8) ) * ( (rightPix >> 8) - (thisPix >> 8) );
                        //System.out.print(greenDiff);

                        int blueDiff = (( rightPix) - (thisPix)) * ( (rightPix) - (thisPix) );
                        //System.out.print(blueDiff);

                        double diff = Math.sqrt( Math.abs(redDiff + greenDiff + blueDiff) );
                        //System.out.print(doubleDiff);


                        if (diff < 40000) 
                        {
                            newImage.setRGB(c, r, 0x00000000);  //white
                            newImage.setRGB(c + 1, r, 0x00ffffff);  //black
                        }
                        else
                        {
                            newImage.setRGB(c, r, 0x00ffffff); 
                            newImage.setRGB(c + 1, r, 0x00000000); 
                        }
                    }

                }
            }

            ImageIO.write(newImage, "jpg",new File(newTitle + ".jpg"));

        }

        /**
        *  A method that contains every method in the program. the userinterface is designed to give the user easy access and simplify the code. 
        * @ param none
        */
        public static void runUI() throws IOException
        {   
            Scanner scan = new Scanner(System.in); //scanner
            // asks the user file they want to alter
            System.out.println("Please enter the name of the file you would like to alter: ");
            String title = scan.nextLine();
            File file = new File(title);
            BufferedImage image = ImageIO.read(file);
            // new file name
            System.out.println("Please enter the name you would like to call your altered file: ");
            String newTitle = scan.nextLine();

            // googled this switch statement like a pro 
            System.out.println("Pick a number to alter your image: ?\n1: Make Red\n2: Make Green\n3: Make Blue\n4: Make Inverted\n5: Delete Red\n6: Delete Green\n7: Delete Blue\n8: Make Gray\n9: Make Warhol\n10: Make Mirrored\n11: Rotate Clock Wise\n12: Find Edges");
            int choice = scan.nextInt();

            switch (choice)
            {
                case 1:
                System.out.println("The image will be red");
                makeRed(image, newTitle);
                break;

                case 2:
                System.out.println("The image will be green");
                makeGreen(image, newTitle);
                break;

                case 3:
                System.out.println("The image will be blue");
                makeBlue(image, newTitle);
                break;

                case 4:
                System.out.println("The image will be inverted");
                Invert(image, newTitle);
                break;

                case 5:
                System.out.println("The image will delete red");
                deleteRed(image, newTitle);
                break;

                case 6:
                System.out.println("The image will delete green");
                deleteGreen(image, newTitle);
                break;

                case 7:
                System.out.println("The image will delete blue");
                deleteBlue(image, newTitle);
                break;

                case 8:
                System.out.println("The image will be gray");
                makeGray(image, newTitle);
                break;

                case 9:
                System.out.println("The image will be displayed warhol-style.");
                makeWarhol(image, newTitle);
                break;

                case 10:
                System.out.println("The image will be mirrored. Prepare for #beauty!!"); //choose anokyai.jpg
                makeMirrored(image, newTitle);
                break;

                case 11:
                System.out.println("The image will be rotated clockwise");
                rotateClockWise(image, newTitle);
                break;

                case 12:
                System.out.println("The image will be displayed as black and white lineart. ");
                findEdges(image, newTitle);
                break;
        
                default:
                System.out.println("You did not pick a suitable number.");
            }
        }

   
      public static void main(String[] args) throws IOException
      {
         runUI();

         //everybody was kung fu fighting for realz
         
      }
   }
