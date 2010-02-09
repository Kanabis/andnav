// Created by plusminus on 20:50:06 - 03.10.2008
package org.andnav2.osm.views.overlay;

import org.andnav2.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public abstract class AbstractOSMMapViewItemizedOverlayWithFocus<T extends OSMMapViewOverlayItem> extends AbstractOSMMapViewItemizedOverlay<T> {
	// ===========================================================
	// Constants
	// ===========================================================

	public static final int DESCRIPTION_BOX_PADDING = 3;
	public static final int DESCRIPTION_BOX_CORNERWIDTH = 3;

	public static final int DESCRIPTION_LINE_HEIGHT = 12;
	/** Additional to <code>DESCRIPTION_LINE_HEIGHT</code>. */
	public static final int DESCRIPTION_TITLE_EXTRA_LINE_HEIGHT = 2;


	protected static final Point DEFAULTMARKER_FOCUSED_HOTSPOT = new Point(10, 19);
	protected static final int DEFAULTMARKER_BACKGROUNDCOLOR = Color.rgb(101, 185, 74);

	protected static final int DESCRIPTION_MAXWIDTH = 200;

	// ===========================================================
	// Fields
	// ===========================================================

	private AbstractOSMMapViewMarker mMarkerFocusedBase;
	@SuppressWarnings("unused")
	private final int mMarkerFocusedBackgroundColor;
	@SuppressWarnings("unused")
	private final int mMarkerFocusedWidth, mMarkerFocusedHeight;
	@SuppressWarnings("unused")
	private final Paint mMarkerBackgroundPaint, mDescriptionPaint, mTitlePaint;

	private T mFocusedItem;
	private boolean mFocusItemsOnTap = true;

	@SuppressWarnings("unused")
	private final String UNKNOWN;

	protected int mPaddingTitleLeft = 10;
	@SuppressWarnings("unused")
	private final int mPaddingTitleRight = 0;
	protected boolean mDrawBaseIntemUnderFocusedItem = false;

	// ===========================================================
	// Constructors
	// ===========================================================

	public AbstractOSMMapViewItemizedOverlayWithFocus(final Context ctx, 
			AbstractOSMMapViewMarker pMarker, 
			AbstractOSMMapViewMarker pMarkerFocusedBase,
			final int pFocusedBackgroundColor, 
			final OnItemTapListener<T> aOnItemTapListener) 
	{
		super(ctx, pMarker, aOnItemTapListener);
		assert(mMarkerFocusedBase != null);

		this.UNKNOWN = ctx.getString(R.string.unknown);
		this.mMarkerFocusedBase = pMarkerFocusedBase;

		this.mMarkerFocusedBackgroundColor = (pFocusedBackgroundColor != NOT_SET) 
			? pFocusedBackgroundColor : DEFAULTMARKER_BACKGROUNDCOLOR;

		this.mMarkerBackgroundPaint = new Paint(); // Color is set in onDraw(...)

		this.mDescriptionPaint = new Paint();
		this.mDescriptionPaint.setAntiAlias(true);
		this.mTitlePaint = new Paint();
		this.mTitlePaint.setFakeBoldText(true);
		this.mTitlePaint.setAntiAlias(true);

		this.mMarkerFocusedWidth = this.mMarkerFocusedBase.getIntrinsicWidth();
		this.mMarkerFocusedHeight = this.mMarkerFocusedBase.getIntrinsicHeight();
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	@Override
	public void release() {
		super.release();
		this.mMarkerFocusedBase = null;
	}

	public T getFocusedItem() {
		return this.mFocusedItem;
	}

	public void setFocusedItem(final T pItem){
		this.mFocusedItem = pItem;
	}

	public void unSetFocusedItem(){
		this.mFocusedItem = null;
	}

	public void setAutoFocusItemsOnTap(final boolean doit) {
		this.mFocusItemsOnTap = doit;
	}

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	@Override
	protected boolean onTap(final int pIndex) {
		if(this.mFocusItemsOnTap) {
			this.mFocusedItem = getOverlayItems().get(pIndex);
		}
		return super.onTap(pIndex);
	}


	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
