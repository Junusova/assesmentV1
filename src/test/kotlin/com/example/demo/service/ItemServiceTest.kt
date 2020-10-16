package service

import com.example.demo.repo.ItemsRepository
import com.example.demo.service.ItemsService
import helpers.takeCreateItemRequest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import utils.ServiceTest


class ItemServiceTest : ServiceTest() {

  @Mock
  private val itemsRepository: ItemsRepository? = null

  @Mock
  private lateinit var itemsService: ItemsService

  @Test
  fun createItemTest() {
    if (itemsRepository != null) {
      given(itemsRepository.save(takeCreateItemRequest())).willReturn(takeCreateItemRequest())
      val expected = itemsService.save(takeCreateItemRequest())
      assertEquals(expected, takeCreateItemRequest())
    }
  }
}