package org.andnav2.sys.ors.views.overlay;

import org.andnav2.R;
import org.andnav2.adt.Favorite;
import org.andnav2.osm.views.OSMMapView.OSMMapViewProjection;
import org.andnav2.osm.views.util.Util;

import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.widget.Toast;


public class FavoritePoint extends BitmapItem {

	// ===========================================================
	// Constants
	// ===========================================================

    public final int MAX_DISTANCE = 80;
    protected final Favorite fCenter;

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	public FavoritePoint(final Favorite aCenter, final Context ctx) {
        super(aCenter, ctx, R.drawable.favorites);
        this.fCenter = aCenter;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

    @Override
    public boolean onSingleTapUp(final MotionEvent e, final OSMMapViewProjection pj) {
        final Point screenCoords = new Point();
        pj.toPixels(this.fCenter, screenCoords);
        float distance = Util.calculateDistance(screenCoords.x, (int)e.getX(),
                                                screenCoords.y, (int)e.getY());

        if (distance > MAX_DISTANCE) {
            return false;
        }

        Toast.makeText(ctx, fCenter.getName(), Toast.LENGTH_LONG).show();
        return true;
    }


	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
