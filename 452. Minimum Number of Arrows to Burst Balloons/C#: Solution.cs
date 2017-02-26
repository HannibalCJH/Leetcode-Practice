class Point
{
    public int start;
    public int end;
    public Point(int s, int e)
    {
        this.start = s;
        this.end = e;
    }
}

public class Solution {
    public int FindMinArrowShots(int[,] points) 
    {
        if(points == null || points.GetLength(0) == 0 || points.GetLength(1) == 0)
            return 0;
        // C#不能直接排序多维数组，先把points导入到Point类数组
        Point[] pointArray = new Point[points.GetLength(0)];
        for(int i = 0; i < points.GetLength(0); i++)
            pointArray[i] = new Point(points[i, 0], points[i, 1]);
        
        Array.Sort(pointArray, new PointComparer());
        int count = 1;
        int arrowRange = pointArray[0].end;
        for(int i = 1; i < pointArray.Length; i++)
        {
            if(pointArray[i].start <= arrowRange)
            {
                arrowRange = Math.Min(pointArray[i].end, arrowRange);
            }
            else
            {
                count++;
                arrowRange = pointArray[i].end;
            }
        }
        return count;
    }
    
    class PointComparer : IComparer<Point>
    {
        public int Compare(Point pt1, Point pt2)
        {
            if(pt1.start == pt2.start)
                return pt1.end - pt2.end;
            else
                return pt1.start - pt2.start;
        }
    }
}
