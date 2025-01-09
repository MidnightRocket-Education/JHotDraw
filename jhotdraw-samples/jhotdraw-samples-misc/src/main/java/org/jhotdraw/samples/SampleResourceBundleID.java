package org.jhotdraw.samples;

import org.jhotdraw.util.ResourceBundleIDProvider;

public enum SampleResourceBundleID implements ResourceBundleIDProvider {
	DRAW_VIEW("org.jhotdraw.samples.draw.DrawView"),
	NET_LABELS("org.jhotdraw.samples.net.Labels"),
	NET_VIEW("org.jhotdraw.samples.net.NetView"),
	ODG_LABELS("org.jhotdraw.samples.odg.Labels"),
	PERT_LABELS("org.jhotdraw.samples.pert.Labels"),
	PERT_VIEW("org.jhotdraw.samples.pert.PertView"),
	SVG_LABELS("org.jhotdraw.samples.svg.Labels"),
	SVG_VIEW("org.jhotdraw.samples.svg.SVGView"),
	TEDDY_LABELS("org.jhotdraw.samples.teddy.Labels"),
	TEDDY_VIEW("org.jhotdraw.samples.teddy.TeddyView");


	private final String id;

	private SampleResourceBundleID(final String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}
}
