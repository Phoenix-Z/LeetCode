/**
 * @param {number[][]} points
 * @return {number}
 */
// (222ms)
var findMinArrowShots = function(points) {
    if(points.length === 0)
        return 0;
    points.sort((a, b) => a[0] - b[0]);
    var arrows = 1;
    var now = points[0][1];
    for(let i = 1; i < points.length; i++) {
        now = Math.min(now, points[i][1]);
        if(now >= points[i][0])
            continue;
        arrows++;
        now = points[i][1];
    }
    return arrows;
};
