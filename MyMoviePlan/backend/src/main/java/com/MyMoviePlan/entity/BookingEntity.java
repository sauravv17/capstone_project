package com.MyMoviePlan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "bookings")
public class BookingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    @Column(name = "total_seats")
    private int totalSeats;

    @Column(name = "booked_on")
    @Temporal(TemporalType.DATE)
    private Date bookedOn;

    @Column(name = "date_of_booking")
    @Temporal(TemporalType.DATE)
    private Date dateOfBooking;

    @Column(name = "user_id")
    private String userId;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ElementCollection
    @CollectionTable(name = "booked_seats", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "seat_numbers")
    private List<String> seatNumbers;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(targetEntity = PaymentEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(targetEntity = BookingDetailsEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_details_id")
    private BookingDetailsEntity bookingDetails;

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(targetEntity = MovieShowsEntity.class)
    private MovieShowsEntity movieShow;

    public BookingEntity(double amount, int totalSeats, Date bookedOn, Date dateOfBooking, List<String> seatNumbers,
                         PaymentEntity payment, String userId, MovieShowsEntity movieShow) {
        this.amount = amount;
        this.totalSeats = totalSeats;
        this.bookedOn = bookedOn;
        this.dateOfBooking = dateOfBooking;
        this.seatNumbers = seatNumbers;
        this.payment = payment;
        this.userId = userId;
        this.movieShow = movieShow;
    }

    public BookingEntity setMovieShow(MovieShowsEntity movieShow) {
        this.movieShow = movieShow;
        return this;
    }


    public BookingEntity setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public BookingEntity setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
        return this;
    }

    public BookingEntity setStatus(Date bookedOn) {
        this.bookedOn = bookedOn;
        return this;
    }

    public BookingEntity setDateOfBooking(Date dateOfBooking) {
        this.dateOfBooking = dateOfBooking;
        return this;
    }

    public BookingEntity setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
        return this;
    }

    public BookingEntity setPayment(PaymentEntity payment) {
        this.payment = payment;
        return this;
    }

    public BookingEntity setUserId(String userId) {
        this.userId = userId;
        return this;
    }

	public Date getBookedOn() {
		return bookedOn;
	}

	public void setBookedOn(Date bookedOn) {
		this.bookedOn = bookedOn;
	}

	public BookingDetailsEntity getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetailsEntity bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public int getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public String getUserId() {
		return userId;
	}

	public List<String> getSeatNumbers() {
		return seatNumbers;
	}

	public PaymentEntity getPayment() {
		return payment;
	}

	public MovieShowsEntity getMovieShow() {
		return movieShow;
	}

	
}
