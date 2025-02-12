package com.potatocountry.potatocountry.domain.user.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.potatocountry.potatocountry.data.entitiy.User;
import com.potatocountry.potatocountry.data.repository.UserRepository;
import com.potatocountry.potatocountry.domain.user.dto.request.UserCreateReqDto;
import com.potatocountry.potatocountry.domain.user.dto.response.UserCreateResDto;
import com.potatocountry.potatocountry.global.error.CustomError;
import com.potatocountry.potatocountry.global.error.CustomException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional
	public UserCreateResDto createUser(UserCreateReqDto userCreateReqDto) {
		validateDuplicationId(userCreateReqDto.getLoginId());
		validateDuplicationNickname(userCreateReqDto.getNickname());
		User user = new User(userCreateReqDto.getLoginId(),
			bCryptPasswordEncoder.encode(userCreateReqDto.getPassword()), userCreateReqDto.getUsername(),
			userCreateReqDto.getNickname());
		userRepository.save(user);
		return UserCreateResDto.toDto(user);
	}

	private void validateDuplicationNickname(String nickname) {
		if (userRepository.existsByNickname(nickname)) {
			throw new CustomException(CustomError.USER_DUPLICATION_NICKNAME);
		}
	}

	public void validateDuplicationId(String loginId) {
		if (userRepository.existsByLoginId(loginId)) {
			throw new CustomException(CustomError.USER_DUPLICATION_ID);
		}
	}
}
