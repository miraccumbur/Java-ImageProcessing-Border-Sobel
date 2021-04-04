In createHorizontalEdge class i created a int max value is 0.The i created gYrez and gXrez array two size.Then i
created float formula value is 0. I created a create method. This method get width,height and grayscalepixels.Then i
created two for loop. These are for read every pixel on picture.I controled first and last pixel for width and height.
And i made finding gy operations.and i found max gy value.after that i found formula with i used max value.
and i created gy array.

createverticaledge class same to createhorizontaledge class.Just gy was gx.

Then i created creategEdge class. This class have a create method. This method get gxpixels array, gypixels array,
width and height.In this method i found magnetiude with magnetiude operations for every pixels.And i found max
value like other class and create g array.

Histogram class has a createhistogram method.This method get width,height,and grayscale image pixel.In this method
firstly i found willusingwidth and willusingheight.(width-2 and height-2). Because we cant use first and last column
and row.Then i found widthcount and heightcount. These are for how many 8 pixels have in a row and column. after that
i get gx gy and g on other class. I created two for loop zero to countwidth and zero to countheight. and i created two
loop again for every pixels for 8x8 square. and add pixels value i used this formula value1=(i*8)+k,value2=(j*8)+m; and
i created 8x8 gx gy g. after that these two loop is finished and create same loop. in these loops i create if sturucture
if gx8x8 value is 0 , that value be 0.0000001. and this value is rezValue. if enter else structure rezvalue is gx8x8
value.And i create double degree and that value is Math.toDegrees((Math.atan(gY8x8[k][m]/rezValue))). you did that very
similar version on our zoom meeting. Then i created i new loop zero to nine.In this loop i created new is structure.
This if blocks conditions are allValue[count]<=degree && degree<=allValue[count+1]. All value is our degree array.
that value is 0,20,40,...,180. These are for every degree create a if structure.This is simple.Then i found big and
small.(big like 20 small like 0, these for every degrees).The i found forbig and formula with i use far to our degrees to
0-20,20-40 and others.And i found index allvalue/20; then i created and add sumfor8x8 array.And our magnetude share these.
and i found max value.In last these sumfor8x8 array add to histogramcount list.

In drawingpanelfor2Byte class we created a jpanel like other homework.

In drawingPanelForHistogram class we create jpanel for histogram.In these class similar to other drawing class.
But something is different.Firstly i founded formula with i used to max value.Then i create two loop i=0 to pixels array
size and j=0 and j to pixels array size.And in two loop i used drawline method for every 8x8 pixels. After finished
second for loop, a iused again drawline method nine times. These for draw to sum for every degrees for every 8x8 pixels.

In drawingtab6 class i get valuex array valuey array and pixels arry.And i found firstx first y secondx second y value.
Then i found xlenght(secondx-firstx) and ylength(secondy-firsty) then i created two loop first x to second x and
first y to secondy. and created every 1x1 piksel to 2x2 piksel.

In scantxtfile i read txt file.

In grayscaleimage class i found grayscalepixels.

ın jpgtotxt class i transleted jpg file to txt file.

In saveImg class is not homework.These for me .In these our g picture save jpg file.

In main class. Firstly i get txt file name and scant that. Then i run  createverticaledge, createhorizontaledge
creategEdge class. and get our value. After thar i run histogram class and get histgoram value. after that i run saveImg
class these for me. Then i create a jtabbed pane and our picture and histogram value add these tab. and
add addMouseListener to drawing tab1. i used mousoressed method and i get x location and y location every click.
and created i mouserelased method and created a if block for these clicks in our picture if enter this block count++.
and again this block crated a new if block for count equlas 2. If count equals two we select two location on our picture.
In this if block ı run drawingtab6 class and get a new pixels array .and add a new tab to jtabbed pane. ın this method
i run drawingpanelfor2byte class.



