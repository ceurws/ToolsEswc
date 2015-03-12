package org.fit.layout.eswc.vocabulary;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

/**
 * The Timeline ontology.
 * <p>
 * Extends owl-time ontology (http://www.w3.org/2006/time) with support
 * for several timelines, acting as a backbone to adress time
 * interval/instants. Mainly designed with a multimedia use-case in mind.
 * Copyright (c) Yves Raimond, Samer Abdallah, Centre for Digital Music,
 * Queen Mary, University of London.
 * <p>
 * Namespace TIMELINE.
 * Prefix: {@code <http://purl.org/NET/c4dm/timeline.owl>}
 */
public class TIMELINE {

	/** {@code http://purl.org/NET/c4dm/timeline.owl} **/
	public static final String NAMESPACE = "http://purl.org/NET/c4dm/timeline.owl";

	/** {@code timeline} **/
	public static final String PREFIX = "timeline";

	/**
	 * abstract instant
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#AbstractInstant}.
	 * <p>
	 * An instant defined on an abstract timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#AbstractInstant">#AbstractInstant</a>
	 */
	public static final URI AbstractInstant;

	/**
	 * abstract interval
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#AbstractInterval}.
	 * <p>
	 * An interval defined on an abstract time-line.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#AbstractInterval">#AbstractInterval</a>
	 */
	public static final URI AbstractInterval;

	/**
	 * abstract timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#AbstractTimeLine}.
	 * <p>
	 * Abstract time lines may be used as a backbone for Score, Works, ...
	 * This allows for TimeLine maps to relate works to a given performance
	 * (this part was played at this time).
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#AbstractTimeLine">#AbstractTimeLine</a>
	 */
	public static final URI AbstractTimeLine;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#after}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#after">#after</a>
	 */
	public static final URI after;

	/**
	 * at
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#at}.
	 * <p>
	 * refers to a point or an interval on the time line, through an explicit
	 * datatype
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#at">#at</a>
	 */
	public static final URI at;

	/**
	 * at (date)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#atDate}.
	 * <p>
	 * A subproperty of :at, allowing to address a date (beginning of it for
	 * an instant, all of it for an interval)
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#atDate">#atDate</a>
	 */
	public static final URI atDate;

	/**
	 * at date/time
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#atDateTime}.
	 * <p>
	 * This property links an instant defined on the universal time line to
	 * an XSD date/time value
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#atDateTime">#atDateTime</a>
	 */
	public static final URI atDateTime;

	/**
	 * at (duration)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#atDuration}.
	 * <p>
	 * A property enabling to adress a time point P through the duration of
	 * the interval [0,P] on a continuous timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#atDuration">#atDuration</a>
	 */
	public static final URI atDuration;

	/**
	 * at (integer)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#atInt}.
	 * <p>
	 * A subproperty of :at, having as a specific range xsd:int
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#atInt">#atInt</a>
	 */
	public static final URI atInt;

	/**
	 * at (real)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#atReal}.
	 * <p>
	 * subproperty of :at, having xsd:float as a range
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#atReal">#atReal</a>
	 */
	public static final URI atReal;

	/**
	 * at (year)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#atYear}.
	 * <p>
	 * A subproperty of :at, allowing to address a year (beginning of it for
	 * an instant, all of it for an interval)
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#atYear">#atYear</a>
	 */
	public static final URI atYear;

	/**
	 * at (year/month)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#atYearMonth}.
	 * <p>
	 * A subproperty of :at, allowing to address a year/month (beginning of
	 * it for an instant, all of it for an interval)
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#atYearMonth">#atYearMonth</a>
	 */
	public static final URI atYearMonth;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#before}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#before">#before</a>
	 */
	public static final URI before;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#beginsAt}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#beginsAt">#beginsAt</a>
	 */
	public static final URI beginsAt;

	/**
	 * begins at (date/time)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#beginsAtDateTime}.
	 * <p>
	 * A subproperty of :beginsAt, allowing to address the beginning of an
	 * interval as a date/time
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#beginsAtDateTime">#beginsAtDateTime</a>
	 */
	public static final URI beginsAtDateTime;

	/**
	 * begins at (xsd:duration)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#beginsAtDuration}.
	 * <p>
	 * A property enabling to adress a start time point P of an interval
	 * [P,E] through the duration of the interval [0,P] on a continuous
	 * timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#beginsAtDuration">#beginsAtDuration</a>
	 */
	public static final URI beginsAtDuration;

	/**
	 * begins at (integer)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#beginsAtInt}.
	 * <p>
	 * A subproperty of :beginsAt, having xsd:int as a range
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#beginsAtInt">#beginsAtInt</a>
	 */
	public static final URI beginsAtInt;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#contains}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#contains">#contains</a>
	 */
	public static final URI contains;

	/**
	 * continuous timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#ContinuousTimeLine}.
	 * <p>
	 * A continuous timeline, like the universal one, or the one backing an
	 * analog signal
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#ContinuousTimeLine">#ContinuousTimeLine</a>
	 */
	public static final URI ContinuousTimeLine;

	/**
	 * delay
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#delay}.
	 * <p>
	 * associate a shift map to a particular delay
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#delay">#delay</a>
	 */
	public static final URI delay;

	/**
	 * discrete instant
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#DiscreteInstant}.
	 * <p>
	 * An instant defined on a discrete timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#DiscreteInstant">#DiscreteInstant</a>
	 */
	public static final URI DiscreteInstant;

	/**
	 * discrete interval
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#DiscreteInterval}.
	 * <p>
	 * An interval defined on a discrete timeline, like the one backing a
	 * digital signal
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#DiscreteInterval">#DiscreteInterval</a>
	 */
	public static final URI DiscreteInterval;

	/**
	 * discrete time line
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#DiscreteTimeLine}.
	 * <p>
	 * A discrete time line (like the time line backing a digital signal
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#DiscreteTimeLine">#DiscreteTimeLine</a>
	 */
	public static final URI DiscreteTimeLine;

	/**
	 * domain timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#domainTimeLine}.
	 * <p>
	 * associates a timeline map to its domain timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#domainTimeLine">#domainTimeLine</a>
	 */
	public static final URI domainTimeLine;

	/**
	 * duration
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#duration}.
	 * <p>
	 * the duration of a time interval
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#duration">#duration</a>
	 */
	public static final URI duration;

	/**
	 * duration (integer)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#durationInt}.
	 * <p>
	 * A subproperty of :duration, having xsd:int as a range
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#durationInt">#durationInt</a>
	 */
	public static final URI durationInt;

	/**
	 * duration (xsd:duration)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#durationXSD}.
	 * <p>
	 * A subproperty of :duration, having xsd:duration as a range
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#durationXSD">#durationXSD</a>
	 */
	public static final URI durationXSD;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#during}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#during">#during</a>
	 */
	public static final URI during;

	/**
	 * ends at
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#end}.
	 * <p>
	 * refers to the end of a time interval, through an explicit datatype.
	 * time:hasEnd can be used as well, if you want to associate the end of
	 * the interval to an explicit time point resource
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#end">#end</a>
	 */
	public static final URI end;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#endsAt}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#endsAt">#endsAt</a>
	 */
	public static final URI endsAt;

	/**
	 * ends at (date/time)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#endsAtDateTime}.
	 * <p>
	 * A subproperty of :endsAt, allowing to address the end of an interval
	 * as a date/time
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#endsAtDateTime">#endsAtDateTime</a>
	 */
	public static final URI endsAtDateTime;

	/**
	 * ends at (xsd:duration)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#endsAtDuration}.
	 * <p>
	 * A property enabling to adress an end time point P of an interval [S,P]
	 * through the duration of the interval [0,P] on a continuous timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#endsAtDuration">#endsAtDuration</a>
	 */
	public static final URI endsAtDuration;

	/**
	 * ends at (integer)
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#endsAtInt}.
	 * <p>
	 * A subproperty of :endsAt, having xsd:int as a range
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#endsAtInt">#endsAtInt</a>
	 */
	public static final URI endsAtInt;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#equals}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#equals">#equals</a>
	 */
	public static final URI equals;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#finishedBy}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#finishedBy">#finishedBy</a>
	 */
	public static final URI finishedBy;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#finishes}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#finishes">#finishes</a>
	 */
	public static final URI finishes;

	/**
	 * hop size
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#hopSize}.
	 * <p>
	 * hop size, associated to a uniform windowing map
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#hopSize">#hopSize</a>
	 */
	public static final URI hopSize;

	/**
	 * instant
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#Instant}.
	 * <p>
	 * An instant (same as in OWL-Time)
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#Instant">#Instant</a>
	 */
	public static final URI Instant;

	/**
	 * interval
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#Interval}.
	 * <p>
	 * An interval (same as in OWL-Time). Allen's relationships are defined
	 * in OWL-Time.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#Interval">#Interval</a>
	 */
	public static final URI Interval;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#meets}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#meets">#meets</a>
	 */
	public static final URI meets;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#metBy}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#metBy">#metBy</a>
	 */
	public static final URI metBy;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#onTimeLine}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#onTimeLine">#onTimeLine</a>
	 */
	public static final URI onTimeLine;

	/**
	 * origin
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#origin}.
	 * <p>
	 * associate an origin map to its origin on the domain physical timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#origin">#origin</a>
	 */
	public static final URI origin;

	/**
	 * origin map
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#OriginMap}.
	 * <p>
	 * A timeline map linking a physical timeline to a relative one
	 * (originating at some point on the physical timeline)
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#OriginMap">#OriginMap</a>
	 */
	public static final URI OriginMap;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#overlappedBy}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#overlappedBy">#overlappedBy</a>
	 */
	public static final URI overlappedBy;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#overlaps}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#overlaps">#overlaps</a>
	 */
	public static final URI overlaps;

	/**
	 * physical timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#PhysicalTimeLine}.
	 * <p>
	 * A "physical" time-line (the universal time line (UTC)) is an instance
	 * of this class. Other time zones consists in instances of this class as
	 * well, with a "shifting" time line map relating them to the universal
	 * time line map.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#PhysicalTimeLine">#PhysicalTimeLine</a>
	 */
	public static final URI PhysicalTimeLine;

	/**
	 * range timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#rangeTimeLine}.
	 * <p>
	 * associates a timeline map to its range timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#rangeTimeLine">#rangeTimeLine</a>
	 */
	public static final URI rangeTimeLine;

	/**
	 * relative instant
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#RelativeInstant}.
	 * <p>
	 * An instant defined on a relative timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#RelativeInstant">#RelativeInstant</a>
	 */
	public static final URI RelativeInstant;

	/**
	 * relative interval
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#RelativeInterval}.
	 * <p>
	 * an interval defined on a relative timeline
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#RelativeInterval">#RelativeInterval</a>
	 */
	public static final URI RelativeInterval;

	/**
	 * relative timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#RelativeTimeLine}.
	 * <p>
	 * Semi infinite time line...canonical coordinate system --> adressed
	 * through xsd:duration since the instant 0.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#RelativeTimeLine">#RelativeTimeLine</a>
	 */
	public static final URI RelativeTimeLine;

	/**
	 * sample rate
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#sampleRate}.
	 * <p>
	 * associates a sample rate value to a uniform sampling map
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#sampleRate">#sampleRate</a>
	 */
	public static final URI sampleRate;

	/**
	 * shift map
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#ShiftMap}.
	 * <p>
	 * a map just shifting one timeline to another
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#ShiftMap">#ShiftMap</a>
	 */
	public static final URI ShiftMap;

	/**
	 * begins at
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#start}.
	 * <p>
	 * refers to the beginning of a time interval, through an explicit
	 * datatype. time:hasBeginning can be used as well, if you want to
	 * associate the beginning of the interval to an explicit time point
	 * resource
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#start">#start</a>
	 */
	public static final URI start;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#startedBy}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#startedBy">#startedBy</a>
	 */
	public static final URI startedBy;

	/**
	 * {@code http://purl.org/NET/c4dm/timeline.owl#starts}.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#starts">#starts</a>
	 */
	public static final URI starts;

	/**
	 * on timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#timeline}.
	 * <p>
	 * Relates an interval or an instant to the timeline on which it is
	 * defined. The 29th of August, 2007 would be linked through this
	 * property to the universal timeline, whereas "from 2s to 5s on this
	 * particular signal" would be defined on the signal' timeline.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#timeline">#timeline</a>
	 */
	public static final URI timeline;

	/**
	 * timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#TimeLine}.
	 * <p>
	 * Represents a linear and coherent piece of time -- can be either
	 * abstract (such as the one behind a score) or concrete (such as the
	 * universal time line). Two timelines can be mapped using timeline maps.
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#TimeLine">#TimeLine</a>
	 */
	public static final URI TimeLine;

	/**
	 * timeline map
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#TimeLineMap}.
	 * <p>
	 * Allows to map two time lines together
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#TimeLineMap">#TimeLineMap</a>
	 */
	public static final URI TimeLineMap;

	/**
	 * uniform sampling map
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#UniformSamplingMap}.
	 * <p>
	 * Describe the relation between a continuous time-line and its sampled
	 * equivalent
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#UniformSamplingMap">#UniformSamplingMap</a>
	 */
	public static final URI UniformSamplingMap;

	/**
	 * Uniform sampling and windowing map
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#UniformSamplingWindowingMap}.
	 * <p>
	 * Describes the relation between a continuous time-line, and a time-line
	 * that corresponds to its sampled and windowed equivalent
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#UniformSamplingWindowingMap">#UniformSamplingWindowingMap</a>
	 */
	public static final URI UniformSamplingWindowingMap;

	/**
	 * uniform windowing map
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#UniformWindowingMap}.
	 * <p>
	 * Describes the relation between a discrete time line and its windowed
	 * equivalent
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#UniformWindowingMap">#UniformWindowingMap</a>
	 */
	public static final URI UniformWindowingMap;

	/**
	 * the universal time line
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#universaltimeline}.
	 * <p>
	 * this is the `universal' time line -- can adress time intervals on it
	 * using date/dateTime -- UTC
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#universaltimeline">#universaltimeline</a>
	 */
	public static final URI universaltimeline;

	/**
	 * instant on the universal timeline
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#UTInstant}.
	 * <p>
	 * This concept expresses that an instant defined on the universal
	 * timeline must be associated to a dateTime value
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#UTInstant">#UTInstant</a>
	 */
	public static final URI UTInstant;

	/**
	 * universal timeline interval
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#UTInterval}.
	 * <p>
	 * an interval defined on the universal time line
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#UTInterval">#UTInterval</a>
	 */
	public static final URI UTInterval;

	/**
	 * window length
	 * <p>
	 * {@code http://purl.org/NET/c4dm/timeline.owl#windowLength}.
	 * <p>
	 * window length, associated to a uniform windowing map
	 *
	 * @see <a href="http://purl.org/NET/c4dm/timeline.owl#windowLength">#windowLength</a>
	 */
	public static final URI windowLength;

	static {
		ValueFactory factory = ValueFactoryImpl.getInstance();

		AbstractInstant = factory.createURI(TIMELINE.NAMESPACE, "#AbstractInstant");
		AbstractInterval = factory.createURI(TIMELINE.NAMESPACE, "#AbstractInterval");
		AbstractTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#AbstractTimeLine");
		after = factory.createURI(TIMELINE.NAMESPACE, "#after");
		at = factory.createURI(TIMELINE.NAMESPACE, "#at");
		atDate = factory.createURI(TIMELINE.NAMESPACE, "#atDate");
		atDateTime = factory.createURI(TIMELINE.NAMESPACE, "#atDateTime");
		atDuration = factory.createURI(TIMELINE.NAMESPACE, "#atDuration");
		atInt = factory.createURI(TIMELINE.NAMESPACE, "#atInt");
		atReal = factory.createURI(TIMELINE.NAMESPACE, "#atReal");
		atYear = factory.createURI(TIMELINE.NAMESPACE, "#atYear");
		atYearMonth = factory.createURI(TIMELINE.NAMESPACE, "#atYearMonth");
		before = factory.createURI(TIMELINE.NAMESPACE, "#before");
		beginsAt = factory.createURI(TIMELINE.NAMESPACE, "#beginsAt");
		beginsAtDateTime = factory.createURI(TIMELINE.NAMESPACE, "#beginsAtDateTime");
		beginsAtDuration = factory.createURI(TIMELINE.NAMESPACE, "#beginsAtDuration");
		beginsAtInt = factory.createURI(TIMELINE.NAMESPACE, "#beginsAtInt");
		contains = factory.createURI(TIMELINE.NAMESPACE, "#contains");
		ContinuousTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#ContinuousTimeLine");
		delay = factory.createURI(TIMELINE.NAMESPACE, "#delay");
		DiscreteInstant = factory.createURI(TIMELINE.NAMESPACE, "#DiscreteInstant");
		DiscreteInterval = factory.createURI(TIMELINE.NAMESPACE, "#DiscreteInterval");
		DiscreteTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#DiscreteTimeLine");
		domainTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#domainTimeLine");
		duration = factory.createURI(TIMELINE.NAMESPACE, "#duration");
		durationInt = factory.createURI(TIMELINE.NAMESPACE, "#durationInt");
		durationXSD = factory.createURI(TIMELINE.NAMESPACE, "#durationXSD");
		during = factory.createURI(TIMELINE.NAMESPACE, "#during");
		end = factory.createURI(TIMELINE.NAMESPACE, "#end");
		endsAt = factory.createURI(TIMELINE.NAMESPACE, "#endsAt");
		endsAtDateTime = factory.createURI(TIMELINE.NAMESPACE, "#endsAtDateTime");
		endsAtDuration = factory.createURI(TIMELINE.NAMESPACE, "#endsAtDuration");
		endsAtInt = factory.createURI(TIMELINE.NAMESPACE, "#endsAtInt");
		equals = factory.createURI(TIMELINE.NAMESPACE, "#equals");
		finishedBy = factory.createURI(TIMELINE.NAMESPACE, "#finishedBy");
		finishes = factory.createURI(TIMELINE.NAMESPACE, "#finishes");
		hopSize = factory.createURI(TIMELINE.NAMESPACE, "#hopSize");
		Instant = factory.createURI(TIMELINE.NAMESPACE, "#Instant");
		Interval = factory.createURI(TIMELINE.NAMESPACE, "#Interval");
		meets = factory.createURI(TIMELINE.NAMESPACE, "#meets");
		metBy = factory.createURI(TIMELINE.NAMESPACE, "#metBy");
		onTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#onTimeLine");
		origin = factory.createURI(TIMELINE.NAMESPACE, "#origin");
		OriginMap = factory.createURI(TIMELINE.NAMESPACE, "#OriginMap");
		overlappedBy = factory.createURI(TIMELINE.NAMESPACE, "#overlappedBy");
		overlaps = factory.createURI(TIMELINE.NAMESPACE, "#overlaps");
		PhysicalTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#PhysicalTimeLine");
		rangeTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#rangeTimeLine");
		RelativeInstant = factory.createURI(TIMELINE.NAMESPACE, "#RelativeInstant");
		RelativeInterval = factory.createURI(TIMELINE.NAMESPACE, "#RelativeInterval");
		RelativeTimeLine = factory.createURI(TIMELINE.NAMESPACE, "#RelativeTimeLine");
		sampleRate = factory.createURI(TIMELINE.NAMESPACE, "#sampleRate");
		ShiftMap = factory.createURI(TIMELINE.NAMESPACE, "#ShiftMap");
		start = factory.createURI(TIMELINE.NAMESPACE, "#start");
		startedBy = factory.createURI(TIMELINE.NAMESPACE, "#startedBy");
		starts = factory.createURI(TIMELINE.NAMESPACE, "#starts");
		timeline = factory.createURI(TIMELINE.NAMESPACE, "#timeline");
		TimeLine = factory.createURI(TIMELINE.NAMESPACE, "#TimeLine");
		TimeLineMap = factory.createURI(TIMELINE.NAMESPACE, "#TimeLineMap");
		UniformSamplingMap = factory.createURI(TIMELINE.NAMESPACE, "#UniformSamplingMap");
		UniformSamplingWindowingMap = factory.createURI(TIMELINE.NAMESPACE, "#UniformSamplingWindowingMap");
		UniformWindowingMap = factory.createURI(TIMELINE.NAMESPACE, "#UniformWindowingMap");
		universaltimeline = factory.createURI(TIMELINE.NAMESPACE, "#universaltimeline");
		UTInstant = factory.createURI(TIMELINE.NAMESPACE, "#UTInstant");
		UTInterval = factory.createURI(TIMELINE.NAMESPACE, "#UTInterval");
		windowLength = factory.createURI(TIMELINE.NAMESPACE, "#windowLength");
	}

	private TIMELINE() {
		//static access only
	}

}
