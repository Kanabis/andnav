// Created by plusminus on 7:28:43 PM - Mar 27, 2009
package org.andnav2.osm.views.overlay;

import java.util.List;

import android.content.Context;

public class BaseOSMMapViewListItemizedOverlayWithFocus<T extends OSMMapViewOverlayItem> 
		extends AbstractOSMMapViewItemizedOverlayWithFocus<T> 
{
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private List<T> mItems;

	// ===========================================================
	// Constructors
	// ===========================================================

	public BaseOSMMapViewListItemizedOverlayWithFocus(final Context ctx, 
			final List<T> pList, 
			final AbstractOSMMapViewMarker pMarker, 
			final AbstractOSMMapViewMarker pMarkerFocusedBase,
			final int pFocusedBackgroundColor, 
			final OnItemTapListener<T> pOnItemTapListener) {
		super(ctx, pMarker, pMarkerFocusedBase, pFocusedBackgroundColor, pOnItemTapListener);
		this.mItems = pList;
	}
	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	@Override
	public List<T> getOverlayItems() {
		return this.mItems;
	}

	@Override
	public void setOverlayItems(final List<T> pItems) {
		this.mItems = pItems;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}